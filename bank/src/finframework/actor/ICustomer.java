package finframework.actor;

import java.util.List;

public interface ICustomer {

    void addAccount(IAccount iAccount);

    void getAccount(String id);

    List<IAccount> getAllAccounts();
}
