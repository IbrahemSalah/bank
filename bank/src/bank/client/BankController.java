package bank.client;

import bank.actorfactory.account.AccountCreationParam;
import bank.actorfactory.account.BankAccountTypeEnum;
import bank.actorfactory.account.ConcreteAccountFactory;
import bank.actorfactory.customer.BankCustomerTypeEnum;
import bank.actorfactory.customer.ConcreteCustomerFactory;
import bank.actorfactory.customer.CustomerCreationParam;
import finframework.actor.ICustomer;
import finframework.client.Company;
import finframework.client.HistoryFunctor;

public class BankController extends Company {
    HistoryFunctor functor = new HistoryFunctor();
    ConcreteCustomerFactory concreteCustomerFactory = new ConcreteCustomerFactory();
    ConcreteAccountFactory concreteAccountFactory = new ConcreteAccountFactory();

    public void createCustomer(BankCustomerTypeEnum bankCustomerTypeEnum, CustomerCreationParam customerCreationParam) {
        customerList.add(concreteCustomerFactory.createCustomer(bankCustomerTypeEnum, customerCreationParam));
    }

    public void createAccount(BankCustomerTypeEnum bankCustomerTypeEnum, BankAccountTypeEnum bankAccountTypeEnum, AccountCreationParam accountCreationParam) {


        concreteAccountFactory.createAccount(bankAccountTypeEnum, accountCreationParam);
    }

    @Override
    public void createCustomer() {

    }

    @Override
    public void createAccount() {

    }

    @Override
    public void addInterest() {

    }


    public ICustomer getOrCreateCustomer(String email) {
        for (ICustomer customer : customerList) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                return customer;
            }
        }

        //todo here we should continue
        return null;
    }
}
