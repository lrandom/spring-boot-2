package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.ui.Model;
import prepedu.com.springbootdemo2.models.Product;

import java.util.ArrayList;

public interface ICrud {
    public String create();

    public String list(Model model);

    public String update();

    public String delete();
}
