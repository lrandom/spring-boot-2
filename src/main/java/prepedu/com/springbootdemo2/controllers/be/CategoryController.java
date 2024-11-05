package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prepedu.com.springbootdemo2.dto.CategoryDTO;
import prepedu.com.springbootdemo2.dto.UserDTO;
import prepedu.com.springbootdemo2.services.CategoryService;
import prepedu.com.springbootdemo2.services.UserService;

@RequestMapping("admin/category")
@Controller
public class CategoryController implements ICRUD<CategoryDTO> {
    @Autowired
    CategoryService categoryService;

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dto", new CategoryDTO());
        return "be/category/create";
    }

    @Override
    @PostMapping("/create")
    public String handleCreate(@ModelAttribute CategoryDTO dto, RedirectAttributes redirectAttributes) {
        categoryService.create(dto, redirectAttributes);
        return "redirect:/admin/category/create";
    }


    @Override
    @GetMapping("/list")
    public String list(Model model) {
        categoryService.list(model);
        return "be/category/list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(Long id, Model model) {
        categoryService.getOne(id, model);
        return "be/category/update";
    }

    @Override
    @PostMapping("/update/{id}")
    public String handleUpdate(Long id, CategoryDTO userDTO) {
        categoryService.update(id, userDTO);
        return "redirect:/admin/category/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(Long id) {
        categoryService.deleteOne(id);
        return "redirect:/admin/category/list";
    }

}
