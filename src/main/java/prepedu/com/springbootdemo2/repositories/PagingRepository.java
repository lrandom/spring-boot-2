package prepedu.com.springbootdemo2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import prepedu.com.springbootdemo2.entities.Post;

@Repository
public interface PagingRepository
        extends PagingAndSortingRepository<Post, Long> {

    @Query("SELECT COUNT(p) FROM posts p")
    int getTotalRecords();
}
