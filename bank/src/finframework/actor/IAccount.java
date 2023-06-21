package finframework.actor;

import bank.actorfactory.account.BankAccountTypeEnum;

public interface IAccount {
    double getBalance();
    double addInterest();
    String getId();
    String getEmail();

    BankAccountTypeEnum getType();
}
