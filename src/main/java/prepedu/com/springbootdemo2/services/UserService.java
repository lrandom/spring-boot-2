package prepedu.com.springbootdemo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prepedu.com.springbootdemo2.dto.UserDTO;
import prepedu.com.springbootdemo2.entities.User;
import prepedu.com.springbootdemo2.repositories.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void createUser(UserDTO dto, RedirectAttributes redirectAttributes) {
        try {
            userRepo.save(dto.mapToUser());
            redirectAttributes.addFlashAttribute("success_message", "User created successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error_message", "User created failed");
        }
    }

    public void listUser(Model model) {
        userRepo.findAll().forEach(user -> {
            model.addAttribute("users", user.mapToDTO());
        });
    }

    public void getUser(Long id, Model model) {
        userRepo.findById(id).ifPresent(user -> {
            model.addAttribute("dto", user.mapToDTO());
        });
    }

    public void updateUser(Long id, UserDTO userDTO) {
        userRepo.findById(id).ifPresent(user -> {
            userRepo.save(userDTO.mapToUser());
        });
    }

    public void deleteUser(Long id) {
        userRepo.findById(id).ifPresent(user -> {
            userRepo.delete(user);
        });
    }
}
