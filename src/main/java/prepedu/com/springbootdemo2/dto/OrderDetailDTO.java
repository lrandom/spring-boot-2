package prepedu.com.springbootdemo2.dto;

import lombok.Data;
import prepedu.com.springbootdemo2.entities.OrderDetail;

@Data
public class OrderDetailDTO {
    Long id;
    Long orderId;
    Long productId;
    Integer quantity;
    Float price;

    //to entities
    public OrderDetail mapToOrderDetail() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetail.setOrderId(orderId);
        orderDetail.setProductId(productId);
        orderDetail.setQuantity(quantity);
        orderDetail.setPrice(price);
        return orderDetail;
    }
}
