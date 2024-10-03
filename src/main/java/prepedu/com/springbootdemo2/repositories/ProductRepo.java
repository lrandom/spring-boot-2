package prepedu.com.springbootdemo2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import prepedu.com.springbootdemo2.entities.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
}
