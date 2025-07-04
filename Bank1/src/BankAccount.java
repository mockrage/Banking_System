public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor that takes account number, account holder's name, and initial deposit
    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // Method to get the balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Successful withdrawal
        }
        return false; // Insufficient funds
    }

    // Method to get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to get account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }
}
