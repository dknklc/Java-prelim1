package shoppingStrategy;

import entity.Customer;
import entity.Store;

import java.util.List;

public interface IShoppingStrategy {

    public void doShopping(Customer customer, List<Store> stores);

    public String getAbbreviation();

}
