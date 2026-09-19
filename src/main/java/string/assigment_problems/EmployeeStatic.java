package string.assigment_problems;

class Employee {

    String empName;
    double salary;

    static String companyName = "Tech Solutions";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Employees Created: " + employeeCount);
    }
}

public class EmployeeStatic {

    public static void main(String[] args) {

        Employee employee1 =
                new Employee("Arun", 50000);

        Employee employee2 =
                new Employee("Priya", 60000);

        System.out.println("Employee 1: " +
                employee1.empName + " | " + employee1.salary);

        System.out.println("Employee 2: " +
                employee2.empName + " | " + employee2.salary);

        Employee.printCompanyInfo();
    }
}