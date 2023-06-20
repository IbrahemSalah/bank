package finframework.actorfactory;

import finframework.actor.IAccount;

public interface IAccountFactory<T> {

    IAccount createAccount(T t);

}
