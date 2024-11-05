package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ICRUD<DTO> {
    public String create(Model model);

    @PostMapping("/create")
    String handleCreate(@ModelAttribute DTO dto, RedirectAttributes redirectAttributes);

    public String list(Model model);

    public String update(@PathVariable(name = "id") Long id, Model model);

    public String handleUpdate(@PathVariable(name = "id") Long id,@ModelAttribute DTO dto);

    @GetMapping("/delete/{id}")
    String delete(@PathVariable(name = "id") Long id);
}
