package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prepedu.com.springbootdemo2.db.ProductDAO;
import prepedu.com.springbootdemo2.models.Product;

import java.util.ArrayList;

@Controller("product")
@RequestMapping("/admin/product")
public class ProductController implements ICrud {
    @Autowired
    ProductDAO productDAO;

    @Override
    @GetMapping("/create")
    public String create() {
        return "";
    }

    @Override
    @GetMapping("/list")
    public String list(Model model) {
        ArrayList<Product> products = productDAO.list();
        model.addAttribute("products", products);
        return "be/product/list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update() {
        return "";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete() {
        return "";
    }

}
