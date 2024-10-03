package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "products")
@Data
public class Product {
    @GeneratedValue
    @Id
    Long id;

    String name;

    String price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
