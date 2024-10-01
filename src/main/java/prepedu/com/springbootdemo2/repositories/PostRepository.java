package prepedu.com.springbootdemo2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import prepedu.com.springbootdemo2.entities.Post;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
