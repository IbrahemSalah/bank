package bank.actorfactory.account;

import bank.actorfactory.customer.BankCustomerTypeEnum;
import finframework.actor.IAccount;

public abstract class BankAccount implements IAccount {

    String email;
    String accountNumber;

    BankCustomerTypeEnum bankCustomerTypeEnum;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public BankCustomerTypeEnum getCustomerAccountType() {
        return bankCustomerTypeEnum;
    }
}
