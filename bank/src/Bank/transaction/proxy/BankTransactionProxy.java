package Bank.transaction.proxy;

import Bank.transaction.BankTransactionStrategyManager;
import Finco.transaction.proxy.TransactionProxy;

public class BankTransactionProxy extends TransactionProxy {

    public BankTransactionProxy() {
        this.transactionStrategyManager = new BankTransactionStrategyManager();
    }
}
