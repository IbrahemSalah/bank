package finframework.actor;

import java.util.List;

public interface ICustomer {

    void addAccount(IAccount iAccount);

    IAccount getAccount(String id);

    List<IAccount> getAllAccounts();
}
