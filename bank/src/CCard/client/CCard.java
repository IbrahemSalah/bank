package CCard.client;

import CCard.actorfactory.account.Copper;
import CCard.actorfactory.account.ConcreteCCAccountFactory;
import CCard.actorfactory.account.Gold;
import CCard.actorfactory.account.Silver;
import CCard.actorfactory.customer.ConcreteCCCustomerFactory;
import CCard.actorfactory.customer.CCCustomerCreationParam;
import CCard.transaction.proxy.CCardHistoryFunctor;
import CCard.transaction.proxy.CCardHistoryItem;
import CCard.transaction.proxy.CCardTransactionProxy;
import CCard.transaction.proxy.CCardTransactionType;
import Finco.actor.IAccount;
import Finco.actor.ICustomer;
import Finco.client.Company;

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
            String[] customerData = new String[5];
            for (IAccount account : customer.getAllAccounts()) {
                String accType = "";
                if (account.getClass() == Gold.class)
                    accType = "Gold";
                else if (account.getClass() == Silver.class)
                    accType = "Silver";
                else if (account.getClass() == Copper.class)
                    accType = "Copper";
                customerData = new String[]{ customer.getName(), account.getId(),account.getExpirationDate(),
                        accType, String.valueOf(new DecimalFormat("0.00").format(account.getBalance()))};
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
