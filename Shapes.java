
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

        Shapes s = new Shapes();

        double rect = s.area(10, 5);
        double circle = s.area(7);
        int square = s.area(4);

        System.out.println("Area of Rectangle: " + rect);
        System.out.println("Area of Circle: " + circle);
        System.out.println("Area of Square: " + square);
    }
}