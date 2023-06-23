package Bank.transaction;

import Finco.actor.IAccount;
import Finco.transaction.TransactionStrategy;

public class CompanyTransactionStrategy extends TransactionStrategy {
    @Override
    public IAccount moneyIn(IAccount account, double amount) {
        account.setBalance(account.getBalance() + amount);
        super.sendEmail("Deposit in your account " + account.getEmail() + " " + amount + " Your current balance is" + account.getBalance());
        return account;
    }

    @Override
    public IAccount moneyOut(IAccount account, double amount) {
        account.setBalance(account.getBalance() - amount);
        super.sendEmail("Withdraw in your account " + account.getEmail() + " " + amount + " Your current balance is" + account.getBalance());
        return account;
    }
}
