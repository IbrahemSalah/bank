package creditcard.actorfactory.customer;

import finframework.actor.CustomerTypeEnum;
import finframework.actor.ICustomer;
import finframework.actorfactory.ICustomerFactory;

public class ConcreteCCCustomerFactory implements ICustomerFactory<CCCustomerCreationParam> {
    @Override
    public ICustomer createCustomer(CCCustomerCreationParam CCCustomerCreationParam) {
        ICustomer  customer;
        if (CCCustomerCreationParam.getBankCustomerTypeEnum() == CustomerTypeEnum.Personal) {

            return   new Person(CCCustomerCreationParam.getName(), CCCustomerCreationParam.getCity(), CCCustomerCreationParam.getState(),
                    CCCustomerCreationParam.getZip(), CCCustomerCreationParam.getEmail(), CCCustomerCreationParam.getBirthDate());
        } else if (CCCustomerCreationParam.getBankCustomerTypeEnum() == CustomerTypeEnum.Organization) {
            return new Organization(CCCustomerCreationParam.getName(), CCCustomerCreationParam.getCity(), CCCustomerCreationParam.getState(),
                    CCCustomerCreationParam.getZip(), CCCustomerCreationParam.getEmail(), CCCustomerCreationParam.getNumOfEmployees());
        } else {
            // default account to be created
            return new Person(CCCustomerCreationParam.getName(), CCCustomerCreationParam.getCity(), CCCustomerCreationParam.getState(),
                    CCCustomerCreationParam.getZip(), CCCustomerCreationParam.getEmail(), CCCustomerCreationParam.getBirthDate());
        }
    }
}
