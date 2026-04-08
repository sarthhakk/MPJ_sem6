

import java.io.*;
import java.util.*;


class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) {
        super(msg);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}


class Customer {
    int cid;
    String name;
    double balance;

    Customer(int cid, String name, double balance) {
        this.cid = cid;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println(cid + " | " + name + " | " + balance);
    }
}


public class BankingSystem {

    static Map<Integer, Customer> data = new HashMap<>();
    static final String FILE = "bank.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        loadFromFile();

        int choice;

        do {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Display 5.Exit");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        create(sc);
                        break;

                    case 2:
                        deposit(sc);
                        break;

                    case 3:
                        withdraw(sc);
                        break;

                    case 4:
                        display();
                        break;

                    case 5:
                        saveToFile();
                        System.out.println("Saved & Exit");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);
    }


    static void create(Scanner sc)
            throws InvalidCIDException, InvalidAmountException {

        System.out.print("Enter CID (1-20): ");
        int cid = sc.nextInt();

        if (cid < 1 || cid > 20) {
            throw new InvalidCIDException("CID must be between 1 and 20");
        }

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Amount (>=1000): ");
        double amt = sc.nextDouble();

        if (amt < 1000) {
            throw new InvalidAmountException("Minimum balance is 1000");
        }

        data.put(cid, new Customer(cid, name, amt));
        System.out.println("Account Created");
    }


    static void deposit(Scanner sc) throws InvalidAmountException {

        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        Customer c = data.get(cid);

        if (c == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }

        c.balance += amt;
        System.out.println("Deposit Done");
    }


    static void withdraw(Scanner sc)
            throws InvalidAmountException, InsufficientBalanceException {

        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        Customer c = data.get(cid);

        if (c == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }

        if (amt > c.balance) {
            throw new InsufficientBalanceException("Not enough balance");
        }

        c.balance -= amt;
        System.out.println("Withdraw Done");
    }

    static void display() {
        for (Customer c : data.values()) {
            c.display();
        }
    }


    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            for (Customer c : data.values()) {
                bw.write(c.cid + " " + c.name + " " + c.balance);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }


    static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(" ");

                int cid = Integer.parseInt(d[0]);
                String name = d[1];
                double bal = Double.parseDouble(d[2]);

                data.put(cid, new Customer(cid, name, bal));
            }

        } catch (IOException e) {
            System.out.println("Starting new file...");
        }
    }
}