package bank.client;

import bank.actorfactory.account.Checking;
import bank.actorfactory.account.ConcreteAccountFactory;
import bank.actorfactory.customer.ConcreteCustomerFactory;
import bank.actorfactory.customer.CustomerCreationParam;
import bank.actorfactory.customer.Person;
import bank.transaction.proxy.BankHistoryFunctor;
import bank.transaction.proxy.BankHistoryItem;
import bank.transaction.proxy.BankTransactionProxy;
import bank.transaction.proxy.TransactionType;
import finframework.actor.IAccount;
import finframework.actor.ICustomer;
import finframework.client.Company;
import java.util.ArrayList;
import java.util.List;

public class BankController extends Company<CustomerCreationParam, TransactionType> {
    ConcreteCustomerFactory concreteCustomerFactory = new ConcreteCustomerFactory();
    ConcreteAccountFactory concreteAccountFactory = new ConcreteAccountFactory();


    public BankController() {
        iTransactionProxy = new BankTransactionProxy();
        historyFunctor = new BankHistoryFunctor();
    }

    @Override
    public void createCustomer(CustomerCreationParam customerCreationParam) {
        ICustomer customer = getCustomer(customerCreationParam.getEmail());
        if (customer == null) {
            customer = concreteCustomerFactory.createCustomer(customerCreationParam);
            customerList.add(customer);
        }
        customer.addAccount(concreteAccountFactory.createAccount(customerCreationParam));
    }

    @Override
    public void moneyIn(TransactionType transactionType, String accountNumber, double amount) {

        iTransactionProxy.moneyIn(historyFunctor, new BankHistoryItem(getAccount(accountNumber), amount, transactionType), getAccount(accountNumber), amount);
    }

    @Override
    public void moneyOut(TransactionType transactionType, String accountNumber, double amount) {
        iTransactionProxy.moneyOut(historyFunctor, new BankHistoryItem(getAccount(accountNumber), amount, transactionType), getAccount(accountNumber), amount);
    }

    @Override
    public void addInterest() {
        for (ICustomer customer : customerList) {
            for (IAccount account : customer.getAllAccounts()) {
                moneyIn(TransactionType.Deposit, account.getId(), account.addInterest());
            }
        }

    }

    public List<String[]> getAllAccounts() {
        List<String[]> data = new ArrayList<>();
        for (ICustomer customer : customerList) {
            String[] customerData = new String[6];
            for (IAccount account : customer.getAllAccounts()) {

                String cusType = ((customer.getClass() == Person.class) ? "P" : "C");
                String accType = ((account.getClass() == Checking.class) ? "Ch" : "S");
                customerData = new String[]{account.getId(), customer.getName(), customer.getCity(),
                        cusType, accType, String.valueOf(account.getBalance())};
                data.add(customerData);
            }
        }
        return data;
    }

    public ICustomer getCustomer(String email) {
        for (ICustomer customer : customerList) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                return customer;
            }
        }
        return null;
    }
}
