package CCard.actorfactory.customer;

import Finco.actor.Customer;
import Finco.actor.IAccount;
import Finco.actor.IOrganization;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Customer implements IOrganization {

    List<IAccount> accountList = new ArrayList<>();
    String numOfEmployees;

    public  Organization(String name, String city, String state, String zip, String email, String numOfEmployees){
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
        return accountList.stream().filter(iAccount -> iAccount.getId().equals(id)).toList().get(0);
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return accountList;
    }
}
