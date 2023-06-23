package CCard.transaction.proxy;

import CCard.transaction.CCardTransactionStrategyManager;
import Finco.transaction.proxy.TransactionProxy;

public class CCardTransactionProxy extends TransactionProxy {

    public CCardTransactionProxy() {
        this.transactionStrategyManager = new CCardTransactionStrategyManager();
    }
}
