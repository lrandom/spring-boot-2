package prepedu.com.springbootdemo2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prepedu.com.springbootdemo2.models.Product;

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
        return "fe/home";
    }
}
