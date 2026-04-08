import java.util.Scanner;

class TouristSpot {
    void popularDish() {
        System.out.println("Tourist Spot Popular Dish");
    }
    void knownFor() {
        System.out.println("Tourist Spot Known For");
    }
}

class Shimla extends TouristSpot {
    @Override
    void popularDish() {
        System.out.println("Shimla is popular for its food: Tudkiya Bhath");
    }
    @Override
    void knownFor() {
        System.out.println("Shimla is well known for: Mall Road and Ridge");
    }
}

class Ooty extends TouristSpot {
    @Override
    void popularDish() {
        System.out.println("Ooty is popular for its food: Varkey Biscuits");
    }
    @Override
    void knownFor() {
        System.out.println("Ooty is well known for: Tea Gardens and Botanical Garden");
    }
}

class Lonavala extends TouristSpot {
    @Override
    void popularDish() {
        System.out.println("Lonavala is popular for its food: Chikki");
    }
    @Override
    void knownFor() {
        System.out.println("Lonavala is well known for: Bhushi Dam and Tiger Point");
    }
}

public class lab_3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TouristSpot spot;

        System.out.println("Pick a Hill Station:");
        System.out.println("1. Shimla");
        System.out.println("2. Ooty");
        System.out.println("3. Lonavala");
        System.out.print("Enter option: ");
        int opt = input.nextInt();

        switch (opt) {
            case 1:
                spot = new Shimla();
                break;
            case 2:
                spot = new Ooty();
                break;
            case 3:
                spot = new Lonavala();
                break;
            default:
                System.out.println("Wrong choice");
                input.close();
                return;
        }

        spot.popularDish();
        spot.knownFor();
        input.close();
    }
}