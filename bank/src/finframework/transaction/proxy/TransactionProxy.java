package finframework.transaction.proxy;

import finframework.actor.IAccount;
import finframework.transaction.TransactionStrategyManager;
import java.util.function.Function;

public class TransactionProxy implements ITransactionProxy {

    protected TransactionStrategyManager transactionStrategyManager;

    @Override
    public IAccount moneyIn(Function<FunctorInputParam, Double> functor, IAccount account, double amount) {

        IAccount result = transactionStrategyManager.moneyIn(account, amount);
        functor.apply(new FunctorInputParam(result, amount));

        return result;
    }

    @Override
    public IAccount moneyOut(Function<FunctorInputParam, Double> functor, IAccount account, double amount) {

        IAccount result = transactionStrategyManager.moneyOut(account, amount);
        functor.apply(new FunctorInputParam(result, amount));

        return result;
    }

}
