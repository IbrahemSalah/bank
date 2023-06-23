package Finco.transaction.proxy;

import Finco.actor.IAccount;

public class FunctorInputParam {

    private IAccount account;

    private double amount;

    public FunctorInputParam(IAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public IAccount getAccount() {
        return account;
    }

    public void setAccount(IAccount account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
