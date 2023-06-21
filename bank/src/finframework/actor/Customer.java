package finframework.actor;

import java.util.List;

public abstract class Customer implements ICustomer {

    private List<IAccount> accountList;

    private String name;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String email;


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAccount(IAccount iAccount) {
        accountList.add(iAccount);
    }

    public List<IAccount> getAccountList() {
        return accountList;
    }
}
