package bank.actorfactory.account;

import finframework.actor.IAccount;

public abstract class BankAccount implements IAccount {

    String email;
    String accountNumber;

    BankAccountTypeEnum bankAccountTypeEnum;

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
    public BankAccountTypeEnum getType() {
        return bankAccountTypeEnum;
    }
}
