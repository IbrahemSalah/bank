package finframework.actorfactory;

import finframework.actor.ICustomer;

public interface ICustomerFactory <T, E>{

    ICustomer createCustomer(T t, E e);
}
