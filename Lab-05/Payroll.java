abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;

    FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    double hours;
    double rate;

    PartTime(String name, int id, double hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double monthlySalary() {
        return stipend;
    }
}

public class Payroll {
    public static void main(String[] args) {

        Employee[] employees = {
            new FullTime("Niyati", 963, 50000),
            new PartTime("Riya", 964, 80, 300),
            new Intern("Krina", 965, 12000),
            new FullTime("Mahi", 966, 45000)
        };

        double total = 0;

        for (Employee employee : employees) {

            double salary = employee.monthlySalary();

            System.out.println("Name: " + employee.name);
            System.out.println("ID: " + employee.id);
            System.out.println("Monthly Salary: " + salary);

            if (employee instanceof Intern) {
                System.out.println("Note : This employee is an Intern.");
            }

            total = total + salary;

            System.out.println();
        }

        System.out.println("Total Payroll = " + total);
    }
}