package prepedu.com.springbootdemo2;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cookie")
@Controller("cookie")
public class CookieController {
    @GetMapping("/set-cookie")
    public String create(HttpServletResponse response) {
        Cookie cookie = new Cookie("age", "20");
        response.addCookie(cookie);
        return "fe/cookie/create";
    }

    @GetMapping("/get-cookie")
    public String getCookie(@CookieValue(name = "age") String age, Model model) {
        System.out.println("Age: " + age);
        model.addAttribute("age", age);
        return "fe/cookie/get-cookie";
    }
}
