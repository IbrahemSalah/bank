package bank.actorfactory.customer;

import finframework.actor.ICustomer;
import finframework.actorfactory.ICustomerFactory;

public class ConcreteCustomerFactory implements ICustomerFactory<CustomerCreationParam> {
    @Override
    public ICustomer createCustomer(CustomerCreationParam customerCreationParam) {
        ICustomer  customer;
        if (customerCreationParam.getBankCustomerTypeEnum() == BankCustomerTypeEnum.Personal) {

            return   new Person(customerCreationParam.getName(), customerCreationParam.getCity(), customerCreationParam.getState(),
                    customerCreationParam.getZip(), customerCreationParam.getEmail(), customerCreationParam.getBirthDate());
        } else if (customerCreationParam.getBankCustomerTypeEnum() == BankCustomerTypeEnum.Organization) {
            return new Organization(customerCreationParam.getName(), customerCreationParam.getCity(), customerCreationParam.getState(),
                    customerCreationParam.getZip(), customerCreationParam.getEmail(), customerCreationParam.getNumOfEmployees());
        } else {
            // default account to be created
            return new Person(customerCreationParam.getName(), customerCreationParam.getCity(), customerCreationParam.getState(),
                    customerCreationParam.getZip(), customerCreationParam.getEmail(), customerCreationParam.getBirthDate());
        }
    }
}
