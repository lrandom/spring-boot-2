package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prepedu.com.springbootdemo2.dto.ProductDTO;
import prepedu.com.springbootdemo2.repositories.CategoryRepo;
import prepedu.com.springbootdemo2.services.CategoryService;

@Controller
@RequestMapping("/admin/product")
public class ProductController implements ICRUD<ProductDTO> {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    private CategoryService categoryService;

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        categoryRepo.findAll().forEach(category -> {
            model.addAttribute("list", category.mapToDTO());
        });
        return "be/product/create";
    }

    @Override
    public String handleCreate(ProductDTO productDTO, RedirectAttributes redirectAttributes) {
        return "";
    }

    @Override
    public String list(Model model) {

        return "";
    }

    @Override
    public String update(Long id, Model model) {
        return "";
    }

    @Override
    public String handleUpdate(Long id, ProductDTO productDTO) {
        return "";
    }

    @Override
    public String delete(Long id) {
        return "";
    }
}
