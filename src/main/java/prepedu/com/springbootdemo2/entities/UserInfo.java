package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users_info")
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "address")
    String address;

    @Column(name = "phone")
    String phone;

    @OneToOne()
    @JoinColumn(name = "user_id")
    User user;
}
