package prepedu.com.springbootdemo2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prepedu.com.springbootdemo2.models.Product;

import java.util.ArrayList;

@Controller("HomeController")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        Product product = new Product();
        product.id = "1";
        product.name = "Product 1";
        product.price = 100.0f;
        model.addAttribute("title", "Home Page");
        model.addAttribute("product", product);


        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        model.addAttribute("languages", languages);

        model.addAttribute("age", 12);
        return "fe/home";
    }

    @GetMapping("/product-detail")
    public String productDetail(Model model) {
        Product product = new Product();
        product.id = "1";
        product.name = "Product 1";
        product.price = 100.0f;
        model.addAttribute("product", product);
        return "fe/product-detail";
    }
}
