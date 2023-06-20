package finframework.client;

import finframework.transaction.proxy.FunctorInputParam;

import java.util.List;
import java.util.function.Function;

public class HistoryFunctor implements Function<FunctorInputParam, Integer> {
    List<FunctorInputParam> history;

    @Override
    public Integer apply(FunctorInputParam functorInputParam) {
        history.add(functorInputParam);
        return functorInputParam.getAmount();
    }
}
