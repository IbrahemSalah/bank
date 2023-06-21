package bank.actorfactory.account;

public class Saving extends BankAccount {

    final double interestRate = 0.0325;
    double balance;

    BankAccountTypeEnum bankAccountTypeEnum;

    public Saving(String email, String accountNumber, BankAccountTypeEnum bankAccountTypeEnum) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.bankAccountTypeEnum = bankAccountTypeEnum;
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
        return super.getAccountNumber();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public BankAccountTypeEnum getType() {
        return bankAccountTypeEnum;
    }
}
