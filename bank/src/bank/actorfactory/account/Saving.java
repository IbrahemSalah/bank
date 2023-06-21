package bank.actorfactory.account;

import finframework.actor.CustomerTypeEnum;

public class Saving extends BankAccount {

    final double interestRate = 0.0325;
    double balance;

    CustomerTypeEnum customerTypeEnum;

    public Saving(String email, String accountNumber, CustomerTypeEnum bankAccountTypeEnum) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.customerTypeEnum = bankAccountTypeEnum;
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
