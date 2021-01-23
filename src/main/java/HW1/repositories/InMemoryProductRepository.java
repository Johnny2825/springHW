package HW1.repositories;

import HW1.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    Map<Integer, Product> products;

    public InMemoryProductRepository() {
        this.products = new HashMap<>();
        this.products.put(0, new Product(0, "Cheese", 165));
        this.products.put(1, new Product(1, "Sausage", 180));
        this.products.put(2, new Product(2, "Potatoes", 40));
        this.products.put(3, new Product(3, "Onion", 20));
        this.products.put(4, new Product(4, "Bread", 50));
    }

    @Override
    public Map<Integer, Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }

    @Override
    public void add(Product product) {
        products.put(products.size(), product);
    }
}
