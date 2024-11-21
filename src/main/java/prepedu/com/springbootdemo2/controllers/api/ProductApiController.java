package prepedu.com.springbootdemo2.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import prepedu.com.springbootdemo2.dto.ProductDTO;
import prepedu.com.springbootdemo2.entities.Product;
import prepedu.com.springbootdemo2.repositories.ProductRepo;

@RestController
public class ProductApiController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/api/products/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productRepo.findById(id).map(Product::mapToDTO).orElse(null);
    }

}
