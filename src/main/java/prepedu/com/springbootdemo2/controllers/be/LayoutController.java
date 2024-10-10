package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/be")
public class LayoutController {
    @GetMapping("/")
    public String index() {
        return "be/layout";
    }
    @GetMapping("/test")
    public String testLayout() {
        return "be/user/index";
    }
}
