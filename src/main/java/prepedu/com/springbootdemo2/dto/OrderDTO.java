package prepedu.com.springbootdemo2.dto;

import lombok.Data;
import prepedu.com.springbootdemo2.entities.Order;

@Data
public class OrderDTO {
    Long id;
    Float subTotal;
    Float shippingFee;
    Float tax;
    String phone;
    String address;
    Integer status;

    //to entities
    public Order mapToOrder() {
        Order order = new Order();
        order.setId(id);
        order.setSubTotal(subTotal);
        order.setShippingFee(shippingFee);
        order.setTax(tax);
        order.setPhone(phone);
        order.setAddress(address);
        order.setStatus(status);
        return order;
    }
}
