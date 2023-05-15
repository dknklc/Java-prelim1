package shoppingList;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements IShoppingList{
    private List<Product> products;

    public ShoppingList(int size){
        products = new ArrayList<>(size);
    }


    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return products.remove(product);
    }
}
