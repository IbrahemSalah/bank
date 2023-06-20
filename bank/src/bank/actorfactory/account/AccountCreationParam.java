package bank.actorfactory.account;

public class AccountCreationParam {

    private String email;
    private String accId;

    public AccountCreationParam(String email, String accId){
        this.email = email;
        this.accId = accId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }
}
