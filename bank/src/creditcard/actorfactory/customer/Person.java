package creditcard.actorfactory.customer;

import finframework.actor.Customer;
import finframework.actor.IAccount;
import finframework.actor.IPerson;

import java.util.ArrayList;
import java.util.List;

public class Person extends Customer implements IPerson {

    List<IAccount> accountList = new ArrayList<>();
    String birthDate;

    public Person(String name, String city, String state, String zip, String email, String birthDate) {
        this.setName(name);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
        this.setEmail(email);
        this.birthDate = birthDate;
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