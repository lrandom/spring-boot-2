package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    String description;
}

