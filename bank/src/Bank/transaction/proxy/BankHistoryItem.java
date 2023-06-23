package Bank.transaction.proxy;

import Finco.actor.IAccount;
import Finco.transaction.proxy.FunctorInputParam;

public class BankHistoryItem extends FunctorInputParam {

    private TransactionType transactionType;
    public BankHistoryItem(IAccount account, double amount, TransactionType transactionType) {
        super(account, amount);
        this.transactionType = transactionType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
