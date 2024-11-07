package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "images")
public class Image {
    @Id
    @GeneratedValue(generator = "increment")
    Long id;
    String path;
    Long productId;
    Integer isThumbnail = 0;


}
