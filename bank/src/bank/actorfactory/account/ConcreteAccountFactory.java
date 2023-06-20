package bank.actorfactory.account;

import finframework.actor.IAccount;
import finframework.actorfactory.IAccountFactory;

public class ConcreteAccountFactory implements IAccountFactory<BankAccountTypeEnum, AccountCreationParam> {
    @Override
    public IAccount createAccount(BankAccountTypeEnum bankAccountTypeEnum, AccountCreationParam params) {

        if (bankAccountTypeEnum == BankAccountTypeEnum.Saving) {
            return new Saving(params.getEmail(), params.getAccId());
        } else if (bankAccountTypeEnum == BankAccountTypeEnum.Checking) {
            return new Checking(params.getEmail(), params.getAccId());
        } else {
            return new Saving(params.getEmail(), params.getAccId());
        }
    }
}
