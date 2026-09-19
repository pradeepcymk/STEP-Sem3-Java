package string.class_problems;

public class MessCardWallet {

    private int balance;

    public MessCardWallet(int initialBalance) {
        balance = initialBalance;
    }

    public void addMoney(int amount) {
        balance += amount;
    }

    public void spendMoney(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        MessCardWallet wallet = new MessCardWallet(1000);

        System.out.println("Initial Balance: " + wallet.getBalance());

        wallet.addMoney(500);
        System.out.println("After Adding Money: " + wallet.getBalance());

        wallet.spendMoney(300);
        System.out.println("After Spending Money: " + wallet.getBalance());
    }
}