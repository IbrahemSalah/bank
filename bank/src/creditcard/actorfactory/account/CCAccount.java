package creditcard.actorfactory.account;

import finframework.actor.CustomerTypeEnum;
import finframework.actor.IAccount;

public abstract class CCAccount implements IAccount {

    String email;
    String accountNumber;

    CustomerTypeEnum customerTypeEnum;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public CustomerTypeEnum getCustomerAccountType() {
        return customerTypeEnum;
    }
}
