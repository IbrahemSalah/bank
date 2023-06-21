package bank.transaction;

import finframework.actor.CustomerTypeEnum;
import finframework.actor.IAccount;
import finframework.transaction.TransactionStrategyManager;

public class BankTransactionStrategyManager extends TransactionStrategyManager {

    @Override
    public void setTransactionStrategy(IAccount account) {
        if (account.getCustomerAccountType() == CustomerTypeEnum.Personal) {
            transactionStrategy = new PersonalTransactionStrategy();
        } else {
            transactionStrategy = new CompanyTransactionStrategy();
        }
    }
}
