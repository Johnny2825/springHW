package HW1.controller;

import HW1.model.Product;
import HW1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("/")
public class MyController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("cart")
    public String cart(Model model) {
        model.addAttribute("cost", productRepository.getProductById(2).getPrice());
        Map<Integer, Product> products = productRepository.getAllProducts();
        model.addAttribute("products", products);
        return "cart";
    }


    @GetMapping("/")
    public String getForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "index";
    }

    @PostMapping("/form")
    public void create(
            HttpServletResponse response,
            Product product
    ) throws IOException {
        product.setId(productRepository.getAllProducts().size());
        productRepository.add(product);
        System.out.println(productRepository.getAllProducts());
        response.sendRedirect("/");
    }
}
