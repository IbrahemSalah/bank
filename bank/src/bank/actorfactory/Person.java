package bank.actorfactory;

import finframework.actor.Customer;
import finframework.actor.IAccount;
import finframework.actor.IPerson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person extends Customer implements IPerson {

    List<IAccount> accountList = new ArrayList<>();
    Date birthDate;
    Customer customer;

    public  Person(String name, String city, String state, String zip, String email, Date birthDate){
        this.customer.setName(name);
        this.customer.setCity(city);
        this.customer.setState(state);
        this.customer.setZip(zip);
        this.customer.setEmail(email);
        this.birthDate = birthDate;
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