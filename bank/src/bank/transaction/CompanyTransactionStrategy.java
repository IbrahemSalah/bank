package bank.transaction;

import finframework.actor.IAccount;
import finframework.transaction.TransactionStrategy;

public class CompanyTransactionStrategy extends TransactionStrategy {
    @Override
    public IAccount moneyIn(IAccount account, int amount) {
        account.setBalance(account.getBalance() + amount);
        super.sendEmail("Deposit in your account " + account.getEmail() + " " + amount + " Your current balance is" + account.getBalance());
        return account;
    }

    @Override
    public IAccount moneyOut(IAccount account, int amount) {
        account.setBalance(account.getBalance() - amount);
        super.sendEmail("Withdraw in your account " + account.getEmail() + " " + amount + " Your current balance is" + account.getBalance());
        return account;
    }
}
