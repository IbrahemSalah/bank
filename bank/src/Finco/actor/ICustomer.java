package Finco.actor;

import java.util.List;

public interface ICustomer {

    void addAccount(IAccount iAccount);
    IAccount getAccount(String id);
    String getEmail();
    List<IAccount> getAllAccounts();
    String getCity();
    String getName();
    String getExpirationDate();

}
