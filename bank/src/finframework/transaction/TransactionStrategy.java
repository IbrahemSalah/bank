package finframework.transaction;

import finframework.actor.IAccount;

public abstract class TransactionStrategy {
    public abstract IAccount moneyIn(IAccount account, int amount);

    public abstract IAccount moneyOut(IAccount account, int amount);

    public void sendEmail(IAccount iAccount) {
        System.out.println("Notify transaction:" + iAccount.getEmail());
    }
}
