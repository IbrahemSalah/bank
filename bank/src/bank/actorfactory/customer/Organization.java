package bank.actorfactory.customer;

import finframework.actor.Customer;
import finframework.actor.IAccount;
import finframework.actor.IOrganization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Organization extends Customer implements IOrganization {

    List<IAccount> accountList = new ArrayList<>();
    int numOfEmployees;

    public  Organization(String name, String city, String state, String zip, String email, int numOfEmployees){
        this.setName(name);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
        this.setEmail(email);
        this.numOfEmployees = numOfEmployees;
    }

    @Override
    public void addAccount(IAccount iAccount) {
        accountList.add(iAccount);
    }

    @Override
    public IAccount getAccount(String id) {
        return accountList.stream().filter(iAccount -> iAccount.getId() == id).toList().get(0);
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return accountList;
    }
}
