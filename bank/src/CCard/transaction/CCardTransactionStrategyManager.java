package CCard.transaction;

import Finco.actor.CustomerTypeEnum;
import Finco.actor.IAccount;
import Finco.transaction.TransactionStrategyManager;

public class CCardTransactionStrategyManager extends TransactionStrategyManager {

    @Override
    public void setTransactionStrategy(IAccount account) {
        if (account.getCustomerAccountType() == CustomerTypeEnum.Personal) {
            transactionStrategy = new PersonalTransactionStrategy();
        } else {
            transactionStrategy = new CompanyTransactionStrategy();
        }
    }
}
