package finframework.actorfactory;
import finframework.actor.ICustomer;

public interface ICustomerFactory <T>{

    ICustomer createCustomer(T t);
}
