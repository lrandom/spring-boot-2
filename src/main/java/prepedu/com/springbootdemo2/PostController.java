package prepedu.com.springbootdemo2;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prepedu.com.springbootdemo2.db.PostDAO;

@RequestMapping("/post")
@Controller("PostController")
public class PostController {
    @Autowired
    PostDAO postDAO;

    @GetMapping("/list")
    public String listPost(Model model) {
        model.addAttribute("posts", postDAO.list());
        return "fe/post/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model,
                         HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("post", postDAO.get(id));
        Cookie[] cookies = request.getCookies();
        boolean isExist = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals("post_" + id)) {
                    isExist = true;
                    break;
                }
            }
        }
        if (isExist == false) {
            Cookie cookie = new Cookie("post_" + id, "true");
            cookie.setMaxAge(60 * 60 * 24);

            response.addCookie(cookie);
            postDAO.updateView(id);
            System.out.println("Update counter");
        }
        return "fe/post/detail";
    }
}
