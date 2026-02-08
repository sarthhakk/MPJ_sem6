class Employee {
    double salary = 20000;   // base salary

    void DisplaySalary() {
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    void CalculateSalary() {
        salary = salary + (salary * 0.50);   // 50% hike
    }
}

class InternEmployee extends Employee {

    void CalculateSalary() {
        salary = salary + (salary * 0.25);   // 25% hike
    }
}

public class Main {
    public static void main(String[] args) {

        FullTimeEmployee f = new FullTimeEmployee();
        InternEmployee i = new InternEmployee();

        System.out.println("Full Time Employee:");
        System.out.println("Before hike:");
        f.DisplaySalary();

        f.CalculateSalary();

        System.out.println("After 50% hike:");
        f.DisplaySalary();

        System.out.println("\nIntern Employee:");
        System.out.println("Before hike:");
        i.DisplaySalary();

        i.CalculateSalary();

        System.out.println("After 25% hike:");
        i.DisplaySalary();
    }
}
