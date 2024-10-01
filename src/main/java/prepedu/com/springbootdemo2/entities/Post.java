package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private int view_count;
}
