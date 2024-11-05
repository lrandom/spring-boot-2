package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;
import prepedu.com.springbootdemo2.dto.CategoryDTO;

import java.util.Collection;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    String name;
    String description;

    public CategoryDTO mapToDTO() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.id = id;
        categoryDTO.name = name;
        categoryDTO.description = description;
        return categoryDTO;
    }
}

