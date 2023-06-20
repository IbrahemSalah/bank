package bank.actorfactory;

import finframework.actor.Customer;
import finframework.actor.IAccount;
import finframework.actor.IOrganization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Organization extends Customer implements IOrganization {

    List<IAccount> accountList = new ArrayList<>();
    int numOfEmployees;
    Customer customer;

    public  Organization(String name, String city, String state, String zip, String email, int numOfEmployees){
        this.customer.setName(name);
        this.customer.setCity(city);
        this.customer.setState(state);
        this.customer.setZip(zip);
        this.customer.setEmail(email);
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
