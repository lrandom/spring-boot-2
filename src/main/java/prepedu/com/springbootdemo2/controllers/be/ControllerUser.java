package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prepedu.com.springbootdemo2.dto.UserDTO;
import prepedu.com.springbootdemo2.services.UserService;

@Controller
@RequestMapping("admin/user")
public class ControllerUser implements ICRUD<UserDTO> {
    @Autowired
    UserService userService;

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dto", new UserDTO());
        return "be/user/create";
    }

    @Override
    @PostMapping("/create")
    public String handleCreate(@ModelAttribute UserDTO dto, RedirectAttributes redirectAttributes) {
        userService.createUser(dto, redirectAttributes);
        return "redirect:/admin/user/create";
    }


    @Override
    @GetMapping("/list")
    public String list(Model model) {
        userService.listUser(model);
        return "be/user/list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(Long id, Model model) {
        userService.getUser(id, model);
        return "be/user/update";
    }

    @Override
    @PostMapping("/update/{id}")
    public String handleUpdate(Long id, UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return "redirect:/admin/user/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user/list";
    }

}
