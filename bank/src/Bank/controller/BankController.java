package Bank.controller;

import Bank.actorfactory.customer.CustomerCreationParam;
import Bank.client.Bank;
import Bank.transaction.proxy.TransactionType;
import Finco.controller.Controller;

import java.util.List;

public class BankController implements Controller<CustomerCreationParam, TransactionType> {
    Bank bank = new Bank();
    @Override
    public void createCustomer(CustomerCreationParam customerCreationParam) {
        bank.createCustomer(customerCreationParam);
    }

    @Override
    public void moneyIn(TransactionType transactionType, String accountNumber, double amount) {
        bank.moneyIn(transactionType, accountNumber, amount);
    }

    @Override
    public void moneyOut(TransactionType transactionType, String accountNumber, double amount) {
        bank.moneyOut(transactionType, accountNumber, amount);
    }

    @Override
    public void addInterest() {
        bank.addInterest();
    }

    @Override
    public List<String[]> getAllAccounts() {
        return bank.getAllAccounts();
    }
}
