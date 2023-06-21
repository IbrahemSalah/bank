package creditcard.transaction.proxy;

import creditcard.transaction.CCardTransactionStrategyManager;
import finframework.transaction.proxy.TransactionProxy;

public class CCardTransactionProxy extends TransactionProxy {

    public CCardTransactionProxy() {
        this.transactionStrategyManager = new CCardTransactionStrategyManager();
    }
}
