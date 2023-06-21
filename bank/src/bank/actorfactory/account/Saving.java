package bank.actorfactory.account;

import bank.actorfactory.customer.BankCustomerTypeEnum;

public class Saving extends BankAccount {

    final double interestRate = 0.0325;
    double balance;

    BankCustomerTypeEnum bankCustomerTypeEnum;

    public Saving(String email, String accountNumber, BankCustomerTypeEnum bankAccountTypeEnum) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.bankCustomerTypeEnum = bankAccountTypeEnum;
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
    public BankCustomerTypeEnum getCustomerAccountType() {
        return bankCustomerTypeEnum;
    }
}
