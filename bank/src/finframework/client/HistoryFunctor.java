package finframework.client;

import finframework.transaction.proxy.FunctorInputParam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HistoryFunctor implements Function<FunctorInputParam, Double> {
    List<FunctorInputParam> history;


    public HistoryFunctor(){
        history = new ArrayList<>();
    }
    @Override
    public Double apply(FunctorInputParam functorInputParam) {
        history.add(functorInputParam);
        return functorInputParam.getAmount();
    }
}
