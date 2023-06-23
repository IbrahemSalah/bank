package Bank.client;

import Bank.actorfactory.account.Checking;
import Bank.actorfactory.account.ConcreteAccountFactory;
import Bank.actorfactory.customer.ConcreteCustomerFactory;
import Bank.actorfactory.customer.CustomerCreationParam;
import Bank.actorfactory.customer.Person;
import Bank.transaction.proxy.BankHistoryFunctor;
import Bank.transaction.proxy.BankHistoryItem;
import Bank.transaction.proxy.BankTransactionProxy;
import Bank.transaction.proxy.TransactionType;
import Finco.actor.IAccount;
import Finco.actor.ICustomer;
import Finco.client.Company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Bank extends Company<CustomerCreationParam, TransactionType> {
    ConcreteCustomerFactory concreteCustomerFactory = new ConcreteCustomerFactory();
    ConcreteAccountFactory concreteAccountFactory = new ConcreteAccountFactory();


    public Bank() {
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
                        cusType,accType, String.valueOf( new DecimalFormat("0.00").format(account.getBalance()))};
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
