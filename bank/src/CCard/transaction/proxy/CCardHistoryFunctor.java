package CCard.transaction.proxy;

import Finco.client.HistoryFunctor;

import java.util.ArrayList;
import java.util.List;

public class CCardHistoryFunctor extends HistoryFunctor<CCardHistoryItem> {
    List<CCardHistoryItem> history;


    public CCardHistoryFunctor() {
        history = new ArrayList<>();
    }

    @Override
    public Double apply(CCardHistoryItem CCardHistoryItem) {
        history.add(CCardHistoryItem);
        return 0.0;
    }
}
