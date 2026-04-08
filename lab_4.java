import java.io.*;
import java.util.*;

class InvalidIDException extends Exception {
    public InvalidIDException(String msg) {
        super(msg);
    }
}

class InvalidDepositException extends Exception {
    public InvalidDepositException(String msg) {
        super(msg);
    }
}

class LowBalanceException extends Exception {
    public LowBalanceException(String msg) {
        super(msg);
    }
}

class AccountExistsException extends Exception {
    public AccountExistsException(String msg) {
        super(msg);
    }
}

class AccountHolder {
    int accNo;
    String name;
    double balance;

    AccountHolder(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void showDetails() {
        System.out.println("Account No: " + accNo + " | Name: " + name + " | Balance: " + balance);
    }
}

public class lab_4 {

    static Map<Integer, AccountHolder> accounts = new HashMap<>();
    static final String DATA_FILE = "accounts.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        readFromFile();

        int opt;
        do {
            System.out.println("\n=== Bank Operations ===");
            System.out.println("1. Open Account");
            System.out.println("2. Add Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Show All Accounts");
            System.out.println("5. Find Account");
            System.out.println("6. Exit");

            System.out.print("Select option: ");
            opt = input.nextInt();

            try {
                switch (opt) {
                    case 1:
                        openAccount(input);
                        break;
                    case 2:
                        addMoney(input);
                        break;
                    case 3:
                        withdrawMoney(input);
                        break;
                    case 4:
                        showAll();
                        break;
                    case 5:
                        findAccount(input);
                        break;
                    case 6:
                        writeToFile();
                        System.out.println("Records saved. Goodbye!");
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                }
            } catch (Exception e) {
                System.out.println("Issue: " + e.getMessage());
            }

        } while (opt != 6);
    }

    static void openAccount(Scanner input)
            throws InvalidDepositException, AccountExistsException {

        System.out.print("Enter Account Number: ");
        int accNo = input.nextInt();

        if (accounts.containsKey(accNo)) {
            throw new AccountExistsException("This account number is already registered!");
        }

        System.out.print("Enter Account Holder Name: ");
        String name = input.next();

        System.out.print("Enter Opening Balance (min 1000): ");
        double bal = input.nextDouble();

        if (bal < 1000) {
            throw new InvalidDepositException("Opening balance cannot be less than 1000");
        }

        accounts.put(accNo, new AccountHolder(accNo, name, bal));
        System.out.println("Account opened successfully!");
    }

    static void addMoney(Scanner input) throws InvalidDepositException {

        System.out.print("Enter Account Number: ");
        int accNo = input.nextInt();

        AccountHolder acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("No such account exists!");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double dep = input.nextDouble();

        if (dep <= 0) {
            throw new InvalidDepositException("Deposit amount should be greater than zero");
        }

        acc.balance += dep;
        System.out.println("Amount added successfully!");
    }

    static void withdrawMoney(Scanner input)
            throws LowBalanceException, InvalidDepositException {

        System.out.print("Enter Account Number: ");
        int accNo = input.nextInt();

        AccountHolder acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("No such account exists!");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double wd = input.nextDouble();

        if (wd <= 0) {
            throw new InvalidDepositException("Withdrawal amount should be greater than zero");
        }

        if (wd > acc.balance) {
            throw new LowBalanceException("Not enough balance in account");
        }

        acc.balance -= wd;
        System.out.println("Amount withdrawn successfully!");
    }

    static void showAll() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display!");
            return;
        }

        for (AccountHolder acc : accounts.values()) {
            acc.showDetails();
        }
    }

    static void findAccount(Scanner input) {
        System.out.print("Enter Account Number: ");
        int accNo = input.nextInt();

        AccountHolder acc = accounts.get(accNo);

        if (acc != null) {
            acc.showDetails();
        } else {
            System.out.println("No such account exists!");
        }
    }

    static void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (AccountHolder acc : accounts.values()) {
                bw.write(acc.accNo + "," + acc.name + "," + acc.balance);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save file: " + e.getMessage());
        }
    }

    static void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts;

                if (line.contains(",")) {
                    parts = line.split(",");
                } else {
                    parts = line.split(" ");
                }

                int accNo = Integer.parseInt(parts[0]);
                String name = parts[1];
                double bal = Double.parseDouble(parts[2]);

                accounts.put(accNo, new AccountHolder(accNo, name, bal));
            }

        } catch (IOException e) {
            System.out.println("No previous records found, starting new.");
        }
    }
}