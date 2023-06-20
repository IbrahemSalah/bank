package finframework.transaction;

import finframework.actor.IAccount;

public abstract class TransactionStrategyManager {

    TransactionStrategy transactionStrategy;

    public abstract void setTransactionStrategy(IAccount account);

    public IAccount moneyIn(IAccount account, int amount) {
        setTransactionStrategy(account);
        return transactionStrategy.moneyIn(account, amount);
    }

    public IAccount moneyOut(IAccount account, int amount) {
        setTransactionStrategy(account);
        return transactionStrategy.moneyOut(account, amount);
    }
}
