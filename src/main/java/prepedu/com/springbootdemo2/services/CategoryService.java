package prepedu.com.springbootdemo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prepedu.com.springbootdemo2.dto.CategoryDTO;
import prepedu.com.springbootdemo2.repositories.CategoryRepo;

import java.util.ArrayList;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void create(CategoryDTO dto, RedirectAttributes redirectAttributes) {
        try {
            categoryRepo.save(dto.mapToCategory());
            redirectAttributes.addFlashAttribute("success_message", "User created successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error_message", "User created failed");
        }
    }

    public void list(Model model) {
        //convert categoryRepo.findAll() to stream

        ArrayList<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryRepo.findAll().forEach(category -> {
            categoryDTOS.add(category.mapToDTO());
        });
        model.addAttribute("list", categoryDTOS);
    }

    public void getOne(Long id, Model model) {
        categoryRepo.findById(id).ifPresent(category -> {
            model.addAttribute("dto", category.mapToDTO());
        });
    }

    public void update(Long id, CategoryDTO userDTO) {
        categoryRepo.findById(id).ifPresent(category -> {
            categoryRepo.save(userDTO.mapToCategory());
        });
    }

    public void deleteOne(Long id) {
        categoryRepo.findById(id).ifPresent(category -> {
            categoryRepo.delete(category);
        });
    }
}
