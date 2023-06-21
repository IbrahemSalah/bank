package finframework.client;

import finframework.actor.IAccount;
import finframework.actor.ICustomer;
import finframework.transaction.proxy.ITransactionProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Company<T> {

    protected List<ICustomer> customerList;
    protected ITransactionProxy iTransactionProxy;
    protected HistoryFunctor historyFunctor;

    public Company() {
        customerList = new ArrayList<>();
    }

    public void moneyIn(String accountNumber, double amount) {
        iTransactionProxy.moneyIn(historyFunctor, getAccount(accountNumber), amount);
    }

    public void moneyOut(String accountNumber, double amount) {
        iTransactionProxy.moneyOut(historyFunctor, getAccount(accountNumber), amount);
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
