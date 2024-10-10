package prepedu.com.springbootdemo2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import prepedu.com.springbootdemo2.entities.User;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    @Query("SELECT COUNT(p) FROM users p")
    int getTotalRecords();
}
