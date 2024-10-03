package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {
    @GeneratedValue(generator = "increment")
    @Id
    Long id;

    @Column(name = "user_name")
    String userName;

    @Column(name = "password")
    String password;

    @OneToOne(mappedBy = "user")
    UserInfo userInfo;
}
