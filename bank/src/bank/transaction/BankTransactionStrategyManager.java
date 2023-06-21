package bank.transaction;

import bank.actorfactory.customer.BankCustomerTypeEnum;
import finframework.actor.IAccount;
import finframework.transaction.TransactionStrategyManager;

public class BankTransactionStrategyManager extends TransactionStrategyManager {

    @Override
    public void setTransactionStrategy(IAccount account) {
        if (account.getCustomerAccountType() == BankCustomerTypeEnum.Personal) {
            transactionStrategy = new PersonalTransactionStrategy();
        } else {
            transactionStrategy = new CompanyTransactionStrategy();
        }
    }
}
