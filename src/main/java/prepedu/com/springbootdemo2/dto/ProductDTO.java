package prepedu.com.springbootdemo2.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import prepedu.com.springbootdemo2.entities.Product;

@Data
public class ProductDTO {
    public Long id;
    public String name;
    public Double price;
    public Double discount;
    public String description;
    public Long categoryId;
    public Long brandId;
    public Integer rateAvg;
    public String thumbnailPath;

    public Product mapToProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setDescription(description);
        product.setCategoryId(categoryId);
        product.setBrandId(brandId);
        product.setRateAvg(rateAvg);
        return product;
    }

    public String getThumbnail() {
        return "/uploads/" + thumbnailPath;
    }
}
