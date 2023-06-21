package bank.actorfactory.account;

import finframework.actor.CustomerTypeEnum;

public class Checking extends BankAccount {

    final double interestRate = 0.01;
    double balance;

    CustomerTypeEnum customerTypeEnum;

    public Checking(String email, String accountNumber, CustomerTypeEnum customerTypeEnum) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.customerTypeEnum = customerTypeEnum;
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
    public String getExpirationDate() {
        return null;
    }

    @Override
    public CustomerTypeEnum getCustomerAccountType() {
        return customerTypeEnum;
    }
}
