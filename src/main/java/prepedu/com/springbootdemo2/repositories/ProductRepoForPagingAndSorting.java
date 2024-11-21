package prepedu.com.springbootdemo2.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import prepedu.com.springbootdemo2.entities.Product;

@Repository
public interface ProductRepoForPagingAndSorting extends PagingAndSortingRepository<Product, Long> {

}
