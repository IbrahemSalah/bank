package Finco.actorfactory;
import Finco.actor.ICustomer;

public interface ICustomerFactory <T>{

    ICustomer createCustomer(T t);
}
