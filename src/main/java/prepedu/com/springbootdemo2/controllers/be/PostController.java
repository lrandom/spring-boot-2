package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prepedu.com.springbootdemo2.entities.Post;
import prepedu.com.springbootdemo2.repositories.PostRepository;

import java.util.Optional;

@Controller
@RequestMapping("/jpa")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/index")
    public String index(Model model) {
        Optional<Post> post = postRepository.findById(1L);
        model.addAttribute("post", post.get());
        return "jpa/index";
    }

}
