package creditcard.actorfactory.account;

import finframework.actor.CustomerTypeEnum;

public class Gold extends CCAccount{

    final double interestRate = 0.12;

    final double minPayment = 0.12;

    double balance;

    CustomerTypeEnum customerTypeEnum;

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
