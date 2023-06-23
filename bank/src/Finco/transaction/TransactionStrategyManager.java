package Finco.transaction;

import Finco.actor.IAccount;

public abstract class TransactionStrategyManager {

    protected TransactionStrategy transactionStrategy;

    public abstract void setTransactionStrategy(IAccount account);

    public IAccount moneyIn(IAccount account, double amount) {
        setTransactionStrategy(account);
        return transactionStrategy.moneyIn(account, amount);
    }

    public IAccount moneyOut(IAccount account, double amount) {
        setTransactionStrategy(account);
        return transactionStrategy.moneyOut(account, amount);
    }
}
