package prepedu.com.springbootdemo2.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;
}
