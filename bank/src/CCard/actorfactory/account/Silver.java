package CCard.actorfactory.account;

import Finco.actor.CustomerTypeEnum;

public class Silver extends CCAccount {

    final double interestRate = 0.16;
    final double minPayment = 0.18;

    double balance;

    CustomerTypeEnum customerTypeEnum;

    public Silver(String email, String accountNumber, CustomerTypeEnum bankAccountTypeEnum, String expirationDate) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.customerTypeEnum = bankAccountTypeEnum;
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
