package Bank.actorfactory.account;

import Bank.actorfactory.customer.CustomerCreationParam;
import Finco.actor.IAccount;
import Finco.actorfactory.IAccountFactory;

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
