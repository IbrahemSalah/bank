package finframework.client;

import bank.actorfactory.customer.CustomerCreationParam;
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

    public void moneyIn(String accountNumber, int amount) {
        iTransactionProxy.moneyIn(historyFunctor, getAccount(accountNumber), amount);
    }

    public void moneyOut(String accountNumber, int amount) {
        iTransactionProxy.moneyOut(historyFunctor, getAccount(accountNumber), amount);
    }

    public abstract void createCustomer(T t);


    public abstract void createAccount();

    public abstract void addInterest();

    public IAccount getAccount(String accountNumber) {

        final IAccount[] result = new IAccount[1];

        customerList.forEach(iCustomer -> {
            result[0] = iCustomer.getAllAccounts().stream().filter(account -> Objects.equals(account.getId(), accountNumber)).toList().get(0);
        });

        return result[0];
    }

    public List<ICustomer> generateReport(){
        return customerList;
    }
}
