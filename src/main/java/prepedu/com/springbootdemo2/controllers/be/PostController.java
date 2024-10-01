package prepedu.com.springbootdemo2.controllers.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import prepedu.com.springbootdemo2.entities.Post;
import prepedu.com.springbootdemo2.repositories.PagingRepository;
import prepedu.com.springbootdemo2.repositories.PostRepository;

import java.util.Optional;

@Controller
@RequestMapping("/jpa")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PagingRepository pagingRepository;

    @GetMapping("/index")
    public String index(Model model) {
        Optional<Post> post = postRepository.findById(1L);
        model.addAttribute("post", post.get());
        return "jpa/index";
    }

    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(defaultValue = "1") int page) {
        if (page < 1) {
            page = 1;
        }
        int totalRecords = pagingRepository.getTotalRecords();
        int totalPages = totalRecords / 3;

        model.addAttribute("totalPages", totalPages);
        if (page > totalPages) {
            page = 1;
        }

        PageRequest pageRequest = PageRequest.of(page, 3);
        model.addAttribute("posts", pagingRepository.findAll(pageRequest).get().toList());
        return "jpa/pagination";
    }
}
