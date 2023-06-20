package finframework.transaction.proxy;

import finframework.actor.IAccount;

import java.util.function.Function;

public interface ITransactionProxy {

    IAccount moneyIn(Function<FunctorInputParam, Integer> functor, IAccount account, int amount);

    IAccount moneyOut(Function<FunctorInputParam, Integer> functor, IAccount account, int amount);
}
