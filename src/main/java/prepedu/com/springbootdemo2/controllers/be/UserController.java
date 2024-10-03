package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import prepedu.com.springbootdemo2.entities.User;
import prepedu.com.springbootdemo2.entities.UserInfo;
import prepedu.com.springbootdemo2.repositories.UserInfoRepo;
import prepedu.com.springbootdemo2.repositories.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    @RequestMapping("/get-profile")
    public String login() {
        User user = userRepo.findById(1L).get();
        UserInfo userInfo = userInfoRepo.findById(2L).get();
        System.out.println(userInfo.getUser().getUserName());
        System.out.println(user.getUserInfo().getAddress());
        return "user-profile";
    }
}
