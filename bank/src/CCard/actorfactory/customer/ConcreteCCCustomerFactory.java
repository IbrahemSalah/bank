package CCard.actorfactory.customer;

import Finco.actor.CustomerTypeEnum;
import Finco.actor.ICustomer;
import Finco.actorfactory.ICustomerFactory;

public class ConcreteCCCustomerFactory implements ICustomerFactory<CCCustomerCreationParam> {
    @Override
    public ICustomer createCustomer(CCCustomerCreationParam CCCustomerCreationParam) {
        ICustomer  customer;
        if (CCCustomerCreationParam.getCCardCustomerTypeEnum() == CustomerTypeEnum.Personal) {

            return   new Person(CCCustomerCreationParam.getName(), CCCustomerCreationParam.getCity(), CCCustomerCreationParam.getState(),
                    CCCustomerCreationParam.getZip(), CCCustomerCreationParam.getEmail(), CCCustomerCreationParam.getBirthDate());
        } else if (CCCustomerCreationParam.getCCardCustomerTypeEnum() == CustomerTypeEnum.Organization) {
            return new Organization(CCCustomerCreationParam.getName(), CCCustomerCreationParam.getCity(), CCCustomerCreationParam.getState(),
                    CCCustomerCreationParam.getZip(), CCCustomerCreationParam.getEmail(), CCCustomerCreationParam.getNumOfEmployees());
        } else {
            // default account to be created
            return new Person(CCCustomerCreationParam.getName(), CCCustomerCreationParam.getCity(), CCCustomerCreationParam.getState(),
                    CCCustomerCreationParam.getZip(), CCCustomerCreationParam.getEmail(), CCCustomerCreationParam.getBirthDate());
        }
    }
}
