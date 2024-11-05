package prepedu.com.springbootdemo2.dto;

import lombok.Data;
import prepedu.com.springbootdemo2.entities.User;

@Data
public class UserDTO {
    public String password;
    public String fullName;
    public String email;
    public String phone;
    public String address;
    public Integer role;
    public Long id;
    public String roleLabel;

    public User mapToUser() {
        User user = new User();
        user.setAddress(address);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRole(role);
        user.setId(id);
        return user;
    }
}
