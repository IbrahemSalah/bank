package Finco.actorfactory;

import Finco.actor.IAccount;

public interface IAccountFactory<T> {

    IAccount createAccount(T t);

}
