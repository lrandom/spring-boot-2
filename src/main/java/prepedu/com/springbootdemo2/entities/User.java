package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.*;
import lombok.Data;
import prepedu.com.springbootdemo2.dto.UserDTO;

@Entity(name = "users")
@Data
public class User {
    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_USER = 2;

    @GeneratedValue(generator = "increment")
    @Id
    Long id;

    @Column(name = "password")
    String password;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "email")
    String email;

    @Column(name = "role")
    Integer role;

    public UserDTO mapToDTO() {
        UserDTO dto = new UserDTO();
        dto.setId(this.id);
        dto.setFullName(this.fullName);
        dto.setPhone(this.phone);
        dto.setAddress(this.address);
        dto.setEmail(this.email);
        dto.setRole(this.role);
        if (this.role == ROLE_ADMIN) {
            dto.setRoleLabel("Admin");
        } else {
            dto.setRoleLabel("User");
        }
        return dto;
    }
}
