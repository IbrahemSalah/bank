package bank.transaction.proxy;

import bank.transaction.BankTransactionStrategyManager;
import finframework.transaction.proxy.TransactionProxy;

public class BankTransactionProxy extends TransactionProxy {

    public BankTransactionProxy() {
        this.transactionStrategyManager = new BankTransactionStrategyManager();
    }
}
