package bank.actorfactory;

public class Saving extends BankAccount{

    final double interestRate = 0.0325;
    double balance;

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
        return super.getAccountNumber();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }
}
