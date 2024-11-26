package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import prepedu.com.springbootdemo2.dto.OrderDetailDTO;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(generator = "increment")
    Long id;

    @Column(name = "order_id")
    Long orderId;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "price")
    Float price;

    //map to dto
    public OrderDetailDTO mapToDTO() {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(id);
        orderDetailDTO.setOrderId(orderId);
        orderDetailDTO.setProductId(productId);
        orderDetailDTO.setQuantity(quantity);
        orderDetailDTO.setPrice(price);
        return orderDetailDTO;
    }
}
