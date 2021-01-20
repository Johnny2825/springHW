package HW1;
import java.util.Map;

public interface ProductRepository {
    Map<Integer, Product> getAllProducts();
    Product getProductById(int id);
}
