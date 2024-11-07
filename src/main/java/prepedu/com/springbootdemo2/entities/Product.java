package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;
import prepedu.com.springbootdemo2.dto.ProductDTO;

import java.util.Collection;

@Entity(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "increment")
    Long id;
    String name;
    Double price;
    Double discount;
    String description;

    @Column(name = "category_id")
    Long categoryId;

    @Column(name = "brand_id")
    Long brandId;

    @Column(name = "rate_avg")
    Integer rateAvg;

    public ProductDTO mapToDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.id = id;
        productDTO.name = name;
        productDTO.price = price;
        productDTO.discount = discount;
        productDTO.description = description;
        productDTO.categoryId = categoryId;
        productDTO.brandId = brandId;
        productDTO.rateAvg = rateAvg;
        productDTO.thumbnailPath = images.stream().findFirst().get().getPath();
        return productDTO;
    }

    //map one to many of image
    @OneToMany(mappedBy = "productId")
    Collection<Image> images;

}
