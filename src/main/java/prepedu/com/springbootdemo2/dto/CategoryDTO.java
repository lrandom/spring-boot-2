package prepedu.com.springbootdemo2.dto;

import lombok.Data;
import prepedu.com.springbootdemo2.entities.Category;

@Data
public class CategoryDTO {
    public Long id;
    public String name;
    public String description;

    public Category mapToCategory() {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        return category;
    }
}
