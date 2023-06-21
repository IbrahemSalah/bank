package finframework.transaction.proxy;

import finframework.actor.IAccount;

import java.util.function.Function;

public interface ITransactionProxy<T> {

    IAccount moneyIn(Function<T, Double> functor, T t, IAccount account, double amount);

    IAccount moneyOut(Function<T, Double> functor, T t, IAccount account, double amount);
}
