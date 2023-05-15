package shoppingList;

import product.Product;

import java.util.List;

public interface IShoppingList {
    public List<Product> getAllProducts();
    public void addProduct(Product product);
    public boolean deleteProduct(Product product);
}
