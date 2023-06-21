package bank.transaction.proxy;

import finframework.client.HistoryFunctor;
import java.util.ArrayList;
import java.util.List;

public class BankHistoryFunctor extends HistoryFunctor<BankHistoryItem> {
    List<BankHistoryItem> history;


    public BankHistoryFunctor() {
        history = new ArrayList<>();
    }

    @Override
    public Double apply(BankHistoryItem bankHistoryItem) {
        history.add(bankHistoryItem);
        return 0.0;
    }
}
