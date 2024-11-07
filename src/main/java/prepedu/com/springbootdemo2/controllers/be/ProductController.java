package prepedu.com.springbootdemo2.controllers.be;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prepedu.com.springbootdemo2.dto.CategoryDTO;
import prepedu.com.springbootdemo2.dto.ProductDTO;
import prepedu.com.springbootdemo2.entities.Category;
import prepedu.com.springbootdemo2.repositories.CategoryRepo;
import prepedu.com.springbootdemo2.services.CategoryService;
import prepedu.com.springbootdemo2.services.ProductService;

import java.util.ArrayList;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin/product")
public class ProductController implements ICrudForProduct<ProductDTO> {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        ArrayList<CategoryDTO> categoryDTOS = new ArrayList<>();
        //get category
        categoryRepo.findAll().forEach(category -> {
            categoryDTOS.add(category.mapToDTO());
        });
        model.addAttribute("categories", categoryDTOS);
        model.addAttribute("dto", new ProductDTO());
        return "be/product/create";
    }

    @Override
    @PostMapping("/create")
    public String handleCreate(ProductDTO productDTO,
                               MultipartFile[] images,
                               RedirectAttributes redirectAttributes
    ) {
        for (int i = 0; i < images.length; i++) {
            System.out.println("images[" + i + "] = " + images[i].getOriginalFilename());
        }
        System.out.println("proctName" + productDTO.getName());
        productService.create(productDTO, images, redirectAttributes);
        return "redirect:/admin/product/create";
    }

    @Override
    public String list(Model model) {
        productService.list(model);
        return "be/product/list";
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
