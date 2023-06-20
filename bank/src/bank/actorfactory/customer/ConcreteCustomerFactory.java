package bank.actorfactory.customer;

import finframework.actor.ICustomer;
import finframework.actorfactory.ICustomerFactory;

public class ConcreteCustomerFactory implements ICustomerFactory<BankCustomerTypeEnum, CustomerCreationParam> {
    @Override
    public ICustomer createCustomer(BankCustomerTypeEnum bankCustomerTypeEnum, CustomerCreationParam customerCreationParam) {

        if (bankCustomerTypeEnum == BankCustomerTypeEnum.Personal) {
            return new Person(customerCreationParam.getName(), customerCreationParam.getCity(), customerCreationParam.getState(),
                    customerCreationParam.getZip(), customerCreationParam.getEmail(), customerCreationParam.getBirthDate());
        } else if (bankCustomerTypeEnum == BankCustomerTypeEnum.Organization) {
            return new Organization(customerCreationParam.getName(), customerCreationParam.getCity(), customerCreationParam.getState(),
                    customerCreationParam.getZip(), customerCreationParam.getEmail(), customerCreationParam.getNumOfEmployees());
        } else {
            // default account to be created
            return new Person(customerCreationParam.getName(), customerCreationParam.getCity(), customerCreationParam.getState(),
                    customerCreationParam.getZip(), customerCreationParam.getEmail(), customerCreationParam.getBirthDate());
        }
    }
}
