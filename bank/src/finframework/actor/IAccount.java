package finframework.actor;


public interface IAccount {
    double getBalance();
    void setBalance(double balance);
    double addInterest();
    String getId();
    String getEmail();

    CustomerTypeEnum getCustomerAccountType();
}
