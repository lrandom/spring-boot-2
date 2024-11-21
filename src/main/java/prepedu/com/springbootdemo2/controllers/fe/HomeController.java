package prepedu.com.springbootdemo2.controllers.fe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prepedu.com.springbootdemo2.repositories.ProductRepoForPagingAndSorting;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ProductRepoForPagingAndSorting productRepoForPagingAndSorting;

    @GetMapping("/")
    public String home(Model model) {
        //get the last 5 products
        //create sort
        Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
        model.addAttribute("lastProducts",
                productRepoForPagingAndSorting.findAll(pageable).stream().map(product -> product.mapToDTO()));
        Pageable pageableForMostSales = PageRequest.of(0, 5, Sort.by("soldCounter").descending());
        model.addAttribute("mostSalesProducts",
                productRepoForPagingAndSorting.findAll(pageableForMostSales).stream().map(product -> product.mapToDTO()));
        return "fe/home/index";
    }
}
