package Finco.client;

import Finco.actor.IAccount;
import Finco.actor.ICustomer;
import Finco.transaction.proxy.ITransactionProxy;

import java.util.ArrayList;
import java.util.List;

public abstract class Company<T, E> {

    protected List<ICustomer> customerList;
    protected ITransactionProxy iTransactionProxy;
    protected HistoryFunctor historyFunctor;

    public Company() {
        customerList = new ArrayList<>();
    }

    public void moneyIn(E e, String accountNumber, double amount) {
        iTransactionProxy.moneyIn(historyFunctor, e, getAccount(accountNumber), amount);
    }

    public void moneyOut(E e, String accountNumber, double amount) {
        iTransactionProxy.moneyOut(historyFunctor, e, getAccount(accountNumber), amount);
    }

    public abstract void createCustomer(T t);

    public abstract void addInterest();

    public IAccount getAccount(String accountNumber) {

        IAccount result = null;
        int index = 0;

        while (result == null && index < customerList.size()) {
            ICustomer iCustomer = customerList.get(index);

            for (IAccount account : iCustomer.getAllAccounts()) {
                if (accountNumber.equals(account.getId())) {
                    result = account;
                    break;
                }
            }
            index++;
        }
        ;

        return result;
    }

    public List<ICustomer> generateReport() {
        return customerList;
    }
}
