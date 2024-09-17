package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import prepedu.com.springbootdemo2.models.Product;

import java.util.ArrayList;

public interface ICrud {
    public String create(Model model);

    public String list(Model model);

    public String update(@PathVariable(name = "id") String id, Model model);

    @GetMapping("/delete/{id}")
    String delete(@PathVariable(name = "id") String id);
}
