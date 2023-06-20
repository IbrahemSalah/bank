package finframework.transaction.proxy;

import finframework.actor.IAccount;

public class FunctorInputParam {

    private IAccount account;

    private int amount;

    public FunctorInputParam(IAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public IAccount getAccount() {
        return account;
    }

    public void setAccount(IAccount account) {
        this.account = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
