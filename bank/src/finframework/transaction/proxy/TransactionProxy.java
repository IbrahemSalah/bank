package finframework.transaction.proxy;

import finframework.actor.IAccount;
import finframework.transaction.TransactionStrategy;
import finframework.transaction.TransactionStrategyManager;

import java.util.List;
import java.util.function.Function;

public class TransactionProxy implements ITransactionProxy {

    TransactionStrategyManager transactionStrategyManager;

    public TransactionProxy(TransactionStrategyManager transactionStrategyManager) {
        this.transactionStrategyManager = transactionStrategyManager;
    }

    @Override
    public IAccount moneyIn(Function<FunctorInputParam, Integer> functor, IAccount account, int amount) {

        IAccount result = transactionStrategyManager.moneyIn(account, amount);
        functor.apply(new FunctorInputParam(result, amount));

        return result;
    }

    @Override
    public IAccount moneyOut(Function<FunctorInputParam, Integer> functor, IAccount account, int amount) {

        IAccount result = transactionStrategyManager.moneyOut(account, amount);
        functor.apply(new FunctorInputParam(result, amount));

        return result;
    }

}
