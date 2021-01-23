package HW1.repositories;
import HW1.model.Product;

import java.util.Map;

public interface ProductRepository {
    Map<Integer, Product> getAllProducts();
    Product getProductById(int id);
    void add(Product product);
}
