package creditcard.actorfactory.account;

import creditcard.actorfactory.customer.CCCustomerCreationParam;
import finframework.actor.IAccount;
import finframework.actorfactory.IAccountFactory;

public class ConcreteCCAccountFactory implements IAccountFactory<CCCustomerCreationParam> {
    @Override
    public IAccount createAccount(CCCustomerCreationParam params) {

        if (params.getCCardAccountTypeEnum() == CCardAccountTypeEnum.Gold) {
            return new Gold(params.getEmail(), params.getAccId(), params.getCCardCustomerTypeEnum());
        } else if (params.getCCardAccountTypeEnum() == CCardAccountTypeEnum.Silver) {
            return new Silver(params.getEmail(), params.getAccId(), params.getCCardCustomerTypeEnum());
        } else if (params.getCCardAccountTypeEnum() == CCardAccountTypeEnum.Copper) {
            return new Copper(params.getEmail(), params.getAccId(), params.getCCardCustomerTypeEnum());
        } else {
            return new Silver(params.getEmail(), params.getAccId(), params.getCCardCustomerTypeEnum());
        }
    }
}
