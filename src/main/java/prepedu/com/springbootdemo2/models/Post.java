package prepedu.com.springbootdemo2.models;

import lombok.Data;

@Data
public class Post {
    int id;
    String title;
    String content;
    int viewCount;
}
