package prepedu.com.springbootdemo2.controllers.fe;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prepedu.com.springbootdemo2.provider.JwtProvider;
import prepedu.com.springbootdemo2.repositories.UserAuthRepo;
import prepedu.com.springbootdemo2.repositories.UserRepo;

@Controller
public class AuthController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserAuthRepo userAuthRepo;

    @Autowired
    JwtProvider jwtProvider;


    @GetMapping("/login")
    public String login() {
        return "fe/auth/login";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
            org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            model.addAttribute("authUser", userAuthRepo.findByEmail(userDetails.getUsername()));

            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("token")) {
                        return "fe/auth/profile";
                    }
                }
            }
            //neu ko co token thi tao token va set cookie
            String jwt = jwtProvider.generateTokenByUsername(userDetails.getUsername());
            Cookie cookie = new Cookie("token", jwt);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            httpServletResponse.addCookie(cookie);
        }
        return "fe/auth/profile";
    }

    @GetMapping("/register")
    public String register() {
        return "fe/auth/register";
    }

    public String logout() {
        return "fe/auth/logout";
    }

 /*   @GetMapping("/fake-user")
    public String fakeUser() {
        User user = new User();
        user.setEmail("admin@admin.com");
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setRole(1);
        userRepo.save(user);
        return "fe/auth/login";
    }*/
}
