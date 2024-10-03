package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prepedu.com.springbootdemo2.entities.Category;
import prepedu.com.springbootdemo2.entities.Product;
import prepedu.com.springbootdemo2.entities.User;
import prepedu.com.springbootdemo2.entities.UserInfo;
import prepedu.com.springbootdemo2.repositories.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/jpa-demo")
public class JPAController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    TagRepo tagRepo;

    @RequestMapping("/get-profile")
    public String login() {
        User user = userRepo.findById(1L).get();
        UserInfo userInfo = userInfoRepo.findById(2L).get();
        System.out.println(userInfo.getUser().getUserName());
        System.out.println(user.getUserInfo().getAddress());
        return "user-profile";
    }

    @GetMapping("/category")
    public String category(Model model) {
        Iterable<Category> categories = categoryRepo.findAll();
        //convert iterable to list
        ArrayList<Category> categoryList = new ArrayList<>();
        categories.forEach(categoryList::add);
        model.addAttribute("categories", categoryList);
        return "category";
    }

    @GetMapping("/products")
    public String products(Model model) {
        ArrayList<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        model.addAttribute("products", products);

        //get all tags
        model.addAttribute("tags", tagRepo.findAll());

        return "jpa/products";
    }
}
