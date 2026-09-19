package string.assigment_problems;

public class EmployeeConstructors {

    int empId;
    String empName;
    double salary;
    boolean isIntern;

    EmployeeConstructors(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    EmployeeConstructors(int empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(
                empId + " | " +
                empName + " | " +
                salary + " | Intern: " +
                isIntern
        );
    }

    public static void main(String[] args) {

        EmployeeConstructors employee1 =
                new EmployeeConstructors(101, "Arun", 50000);

        EmployeeConstructors employee2 =
                new EmployeeConstructors(102, "Priya");

        employee1.printProfile();
        employee2.printProfile();
    }
}