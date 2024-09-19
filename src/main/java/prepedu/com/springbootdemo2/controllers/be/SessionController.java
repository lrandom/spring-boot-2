package prepedu.com.springbootdemo2.controllers.be;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prepedu.com.springbootdemo2.models.User;

@Controller("SessionController")
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/set-session")
    public String setSession(HttpSession httpSession) {
        httpSession.setAttribute("name", "niit");
        httpSession.setAttribute("user", new User("1", "niit"));
        return "fe/session/set-session";
    }

    @GetMapping("/get-session")
    public String getSession(HttpSession httpSession, Model model) {
        String name = (String) httpSession.getAttribute("name");
        User user = (User) httpSession.getAttribute("user");
        model.addAttribute("name", name);
        model.addAttribute("user", user);
        return "fe/session/get-session";
    }
}
