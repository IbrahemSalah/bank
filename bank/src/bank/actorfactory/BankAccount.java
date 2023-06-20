package bank.actorfactory;

import finframework.actor.IAccount;

public abstract class BankAccount implements IAccount {

    String accountNumber;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }



}
