package finframework.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HistoryFunctor<T> implements Function<T, Double> {
    List<T> history;


    public HistoryFunctor(){
        history = new ArrayList<T>();
    }
    @Override
    public Double apply(T functorInputParam) {
        history.add(functorInputParam);
        return 0.0;
    }
}
