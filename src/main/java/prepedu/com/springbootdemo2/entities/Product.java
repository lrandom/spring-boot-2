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

    String price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    Collection<Tag> tags;
}
