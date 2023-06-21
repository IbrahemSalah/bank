package finframework.transaction.proxy;

import finframework.actor.IAccount;

import java.util.function.Function;

public interface ITransactionProxy {

    IAccount moneyIn(Function<FunctorInputParam, Double> functor, IAccount account, double amount);

    IAccount moneyOut(Function<FunctorInputParam, Double> functor, IAccount account, double amount);
}
