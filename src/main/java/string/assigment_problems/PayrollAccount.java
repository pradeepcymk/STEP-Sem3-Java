package string.assigment_problems;

public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        this.basicSalary = basicSalary;
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        bonus += amount;
    }

    public void deductTax(double tax) {
        basicSalary -= tax;
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        PayrollAccount employee = new PayrollAccount(30000);

        System.out.println("Initial Salary: " + employee.getNetSalary());

        employee.creditBonus(5000);
        System.out.println("After Bonus: " + employee.getNetSalary());

        employee.deductTax(3000);
        System.out.println("After Tax: " + employee.getNetSalary());
    }
}