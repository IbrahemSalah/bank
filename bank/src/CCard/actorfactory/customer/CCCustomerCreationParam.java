package CCard.actorfactory.customer;

import CCard.actorfactory.account.CCardAccountTypeEnum;
import Finco.actor.CustomerTypeEnum;

public class CCCustomerCreationParam {
    private String name;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String email;

    private String numOfEmployees;

    private String birthDate;

    private String accId;

    String expirationDate;

    CCardAccountTypeEnum CCardAccountTypeEnum;

    CustomerTypeEnum customerTypeEnum;


    public CCCustomerCreationParam(String name, String street, String city, String state, String zip, String email, String numOfEmployees, String birthDate, String accId
    , CCardAccountTypeEnum CCardAccountTypeEnum, CustomerTypeEnum customerTypeEnum) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.numOfEmployees = numOfEmployees;
        this.birthDate = birthDate;
        this.accId =accId;
        this.CCardAccountTypeEnum = CCardAccountTypeEnum;
        this.customerTypeEnum = customerTypeEnum;
    }

    public CCCustomerCreationParam() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(String numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }


    public void setCCardAccountTypeEnum(CCardAccountTypeEnum CCardAccountTypeEnum) {
        this.CCardAccountTypeEnum = CCardAccountTypeEnum;
    }

    public CustomerTypeEnum getCCardCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCCardCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CCardAccountTypeEnum getCCardAccountTypeEnum() {
        return CCardAccountTypeEnum;
    }


    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }
}
