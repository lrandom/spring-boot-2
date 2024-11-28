package prepedu.com.springbootdemo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prepedu.com.springbootdemo2.entities.User;

public interface UserAuthRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
