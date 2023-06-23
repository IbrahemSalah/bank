package CCard.controller;

import CCard.actorfactory.customer.CCCustomerCreationParam;
import CCard.client.CCard;
import CCard.transaction.proxy.CCardTransactionType;
import Finco.controller.Controller;

import java.util.List;

public class CCardController implements Controller<CCCustomerCreationParam, CCardTransactionType> {
    CCard CCard = new CCard();
    @Override
    public void createCustomer(CCCustomerCreationParam CCCustomerCreationParam) {
        CCard.createCustomer(CCCustomerCreationParam);
    }

    @Override
    public void moneyIn(CCardTransactionType CCardTransactionType, String accountNumber, double amount) {
        CCard.moneyIn(CCardTransactionType, accountNumber, amount);
    }

    @Override
    public void moneyOut(CCardTransactionType CCardTransactionType, String accountNumber, double amount) {
        CCard.moneyOut(CCardTransactionType, accountNumber, amount);
    }

    @Override
    public void addInterest() {
        CCard.addInterest();
    }

    @Override
    public List<String[]> getAllAccounts() {
        return CCard.getAllAccounts();
    }
}
