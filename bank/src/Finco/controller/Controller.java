package Finco.controller;

import java.util.List;

public interface Controller<T, E> {
    void createCustomer(T t);
    void moneyIn(E e, String accountNumber, double amount);
    void moneyOut(E e, String accountNumber, double amount);
    void addInterest();
    List<String[]> getAllAccounts();

}
