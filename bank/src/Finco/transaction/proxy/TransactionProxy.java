package Finco.transaction.proxy;

import Finco.actor.IAccount;
import Finco.transaction.TransactionStrategyManager;
import java.util.function.Function;

public class TransactionProxy<T> implements ITransactionProxy<T> {

    protected TransactionStrategyManager transactionStrategyManager;

    @Override
    public IAccount moneyIn(Function<T, Double> functor, T t, IAccount account, double amount) {

        IAccount result = transactionStrategyManager.moneyIn(account, amount);
        functor.apply(t);

        return result;
    }

    @Override
    public IAccount moneyOut(Function<T, Double> functor, T t, IAccount account, double amount) {

        IAccount result = transactionStrategyManager.moneyOut(account, amount);
        functor.apply(t);

        return result;
    }

}
