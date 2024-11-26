package prepedu.com.springbootdemo2.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import prepedu.com.springbootdemo2.entities.OrderDetail;

@Repository
public interface OrderDetailRepo extends CrudRepository<OrderDetail, Long> {
}
