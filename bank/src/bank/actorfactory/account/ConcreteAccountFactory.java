package bank.actorfactory.account;

import bank.actorfactory.customer.CustomerCreationParam;
import finframework.actor.IAccount;
import finframework.actorfactory.IAccountFactory;

public class ConcreteAccountFactory implements IAccountFactory<CustomerCreationParam> {
    @Override
    public IAccount createAccount(CustomerCreationParam params) {

        if (params.getBankAccountTypeEnum() == BankAccountTypeEnum.Saving) {
            return new Saving(params.getEmail(), params.getAccId(), params.getBankCustomerTypeEnum());
        } else if (params.getBankAccountTypeEnum() == BankAccountTypeEnum.Checking) {
            return new Checking(params.getEmail(), params.getAccId(), params.getBankCustomerTypeEnum());
        } else {
            return new Saving(params.getEmail(), params.getAccId(), params.getBankCustomerTypeEnum());
        }
    }
}
