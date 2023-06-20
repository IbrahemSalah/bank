package bank.actorfactory.account;

public class Checking extends BankAccount {

    final double interestRate = 0.01;
    double balance;

    public Checking(String email, String accountNumber) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double addInterest() {
        return balance * interestRate;
    }

    @Override
    public String getId() {
        return getAccountNumber();
    }

    @Override
    public String getEmail() {
        return getEmail();
    }
}
