package bank.actorfactory.account;

import bank.actorfactory.customer.BankCustomerTypeEnum;

public class Checking extends BankAccount {

    final double interestRate = 0.01;
    double balance;

    BankCustomerTypeEnum bankCustomerTypeEnum;

    public Checking(String email, String accountNumber, BankCustomerTypeEnum bankCustomerTypeEnum) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.bankCustomerTypeEnum = bankCustomerTypeEnum;
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
