package finframework.transaction;

import finframework.actor.IAccount;

public abstract class TransactionStrategy {
    public abstract IAccount moneyIn(IAccount account, double amount);

    public abstract IAccount moneyOut(IAccount account, double amount);

    public void sendEmail(String msg) {
        System.out.println(msg);
    }
}
