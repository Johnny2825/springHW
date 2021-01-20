package HW1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Cart implements CommandLineRunner {
    private final ProductRepository productRepository;
    private List<Product> cart;
    private int id;
    private String str;

    public Cart(@Autowired ProductRepository productRepository) {
        System.out.println("Cart construct");
        this.productRepository = productRepository;
        cart = new ArrayList<>();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Repository " + productRepository.getAllProducts());
        while (true) {
            readFromConsole();
            System.out.println(str);
            System.out.println(id);
            if (str.equals("del")) {
                deleteProduct();
            }
            if (str.equals("add")) {
                addProduct();
            }
        }
    }

    private void readFromConsole() {
        id = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("del or add?");
        str = scanner.nextLine();
        if (!(str.equals("del" ) || str.equals("add"))) {
            System.out.println("It isn't del or add");
            return;
        }
        System.out.println("number?");
        if (scanner.hasNextInt()) {
             id = scanner.nextInt();
        } else {
            System.out.println("It isn't int");
        }
    }

    public void addProduct() {
        if (productRepository.getAllProducts().containsKey(id)) {
            cart.add(productRepository.getProductById(id));
        } else {
            System.out.println("Repository doesn't have this product");
        }
        System.out.println("Cart " + cart);
    }


    public void deleteProduct() {
        if (cart.contains(productRepository.getProductById(id))){
            cart.remove(productRepository.getProductById(id));
        } else {
            System.out.println("Product doesn't found in cart");
        }
        System.out.println("Cart " + cart);
    }
}
