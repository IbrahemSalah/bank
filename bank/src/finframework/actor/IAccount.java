package finframework.actor;

import bank.actorfactory.customer.BankCustomerTypeEnum;

public interface IAccount {
    double getBalance();
    void setBalance(double balance);
    double addInterest();
    String getId();
    String getEmail();

    BankCustomerTypeEnum getCustomerAccountType();
}
