package finframework.actorfactory;

import finframework.actor.IAccount;

public interface IAccountFactory<T, E> {

    IAccount createAccount(T t, E e);

}
