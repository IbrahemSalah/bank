package creditcard.transaction.proxy;

import finframework.actor.IAccount;
import finframework.transaction.proxy.FunctorInputParam;

public class CCardHistoryItem extends FunctorInputParam {

    private CCardTransactionType CCardTransactionType;
    public CCardHistoryItem(IAccount account, double amount, CCardTransactionType CCardTransactionType) {
        super(account, amount);
        this.CCardTransactionType = CCardTransactionType;
    }

    public CCardTransactionType getTransactionType() {
        return CCardTransactionType;
    }

    public void setTransactionType(CCardTransactionType CCardTransactionType) {
        this.CCardTransactionType = CCardTransactionType;
    }
}
