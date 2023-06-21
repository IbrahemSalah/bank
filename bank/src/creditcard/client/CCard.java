package creditcard.client;

import creditcard.actorfactory.account.Copper;
import creditcard.actorfactory.account.ConcreteCCAccountFactory;
import creditcard.actorfactory.customer.ConcreteCCCustomerFactory;
import creditcard.actorfactory.customer.CCCustomerCreationParam;
import creditcard.actorfactory.customer.Person;
import creditcard.transaction.proxy.CCardHistoryFunctor;
import creditcard.transaction.proxy.CCardHistoryItem;
import creditcard.transaction.proxy.CCardTransactionProxy;
import creditcard.transaction.proxy.CCardTransactionType;
import finframework.actor.IAccount;
import finframework.actor.ICustomer;
import finframework.client.Company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CCard extends Company<CCCustomerCreationParam, CCardTransactionType> {
    ConcreteCCCustomerFactory concreteCCCustomerFactory = new ConcreteCCCustomerFactory();
    ConcreteCCAccountFactory concreteCCAccountFactory = new ConcreteCCAccountFactory();


    public CCard() {
        iTransactionProxy = new CCardTransactionProxy();
        historyFunctor = new CCardHistoryFunctor();
    }

    @Override
    public void createCustomer(CCCustomerCreationParam CCCustomerCreationParam) {
        ICustomer customer = getCustomer(CCCustomerCreationParam.getEmail());
        if (customer == null) {
            customer = concreteCCCustomerFactory.createCustomer(CCCustomerCreationParam);
            customerList.add(customer);
        }
        customer.addAccount(concreteCCAccountFactory.createAccount(CCCustomerCreationParam));
    }

    @Override
    public void moneyIn(CCardTransactionType CCardTransactionType, String accountNumber, double amount) {

        iTransactionProxy.moneyIn(historyFunctor, new CCardHistoryItem(getAccount(accountNumber), amount, CCardTransactionType), getAccount(accountNumber), amount);
    }

    @Override
    public void moneyOut(CCardTransactionType CCardTransactionType, String accountNumber, double amount) {
        iTransactionProxy.moneyOut(historyFunctor, new CCardHistoryItem(getAccount(accountNumber), amount, CCardTransactionType), getAccount(accountNumber), amount);
    }

    @Override
    public void addInterest() {
        for (ICustomer customer : customerList) {
            for (IAccount account : customer.getAllAccounts()) {
                moneyIn(CCardTransactionType.Deposit, account.getId(), account.addInterest());
            }
        }

    }

    public List<String[]> getAllAccounts() {
        List<String[]> data = new ArrayList<>();
        for (ICustomer customer : customerList) {
            String[] customerData = new String[6];
            for (IAccount account : customer.getAllAccounts()) {

                String cusType = ((customer.getClass() == Person.class) ? "P" : "C");
                String accType = ((account.getClass() == Copper.class) ? "Ch" : "S");
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
