package creditcard.actorfactory.account;

import finframework.actor.CustomerTypeEnum;

public class Copper extends CCAccount {

    final double interestRate = 0.2;
    final double minPayment = 0.24;
    double balance;

    CustomerTypeEnum customerTypeEnum;

    public Copper(String email, String accountNumber, CustomerTypeEnum customerTypeEnum,String expirationDate) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.customerTypeEnum = customerTypeEnum;
        this.expirationDate = expirationDate;
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
    public CustomerTypeEnum getCustomerAccountType() {
        return customerTypeEnum;
    }
}
