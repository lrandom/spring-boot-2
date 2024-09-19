package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "be/product/create";
    }

    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        Boolean createSuccess = productDAO.create(product);
        if (createSuccess) {
            redirectAttributes.addFlashAttribute("messageSuccess", "Product created successfully");
        }else{
            redirectAttributes.addFlashAttribute("messageFailed", "Product creation failed");
        }
        return "redirect:/admin/product/list";
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
    public String update(@PathVariable(name = "id") String id, Model model) {
        Product product = productDAO.find(id);
        model.addAttribute("product", product);
        return "be/product/update";
    }

    @PostMapping("/update/{id}")
    public String update(Product product) {
        productDAO.update(product);
        return "redirect:/admin/product/list";
    }


    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") String id) {
        productDAO.delete(id);
        return "redirect:/admin/product/list";
    }

}
