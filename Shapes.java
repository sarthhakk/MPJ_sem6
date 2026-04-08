import java.util.Scanner;

class Shapes {

    double length, breadth, radius;

    Shapes(double l, double b) {
        length = l;
        breadth = b;
    }

    Shapes(double r) {
        radius = r;
    }

    Shapes() {
        length = breadth = radius = 0;
    }

    double area(double l, double b) {
        return l * b;
    }

    double area(double r) {
        return Math.PI * r * r;
    }

    int area(int side) {
        return side * side;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Shapes s = new Shapes();

        int choice;

        do {
            System.out.println("\n1. Rectangle\n2. Circle\n3. Square\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter breadth: ");
                    double b = sc.nextDouble();

                    System.out.println("Area of Rectangle: " + s.area(l, b));
                    break;

                case 2:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();

                    System.out.println("Area of Circle: " + s.area(r));
                    break;

                case 3:
                    System.out.print("Enter side: ");
                    int side = sc.nextInt();

                    System.out.println("Area of Square: " + s.area(side));
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }
}