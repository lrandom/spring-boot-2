package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "products")
@Data
public class Product {
    @GeneratedValue
    @Id
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

}
