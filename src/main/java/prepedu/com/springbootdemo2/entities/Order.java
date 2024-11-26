package prepedu.com.springbootdemo2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import prepedu.com.springbootdemo2.dto.OrderDTO;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "increment")
    Long id;

    @Column(name = "sub_total")
    Float subTotal;

    @Column(name = "shipping_fee")
    Float shippingFee;

    @Column(name = "tax")
    Float tax;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "status")
    Integer status;

    @Column(name = "total")
    Float total;

    @Column(name = "full_name")
    String fullName;

    //map to dto
    public OrderDTO mapToDTO() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(id);
        orderDTO.setSubTotal(subTotal);
        orderDTO.setShippingFee(shippingFee);
        orderDTO.setTax(tax);
        orderDTO.setPhone(phone);
        orderDTO.setAddress(address);
        orderDTO.setStatus(status);
        orderDTO.setTotal(total);
        orderDTO.setFullName(fullName);
        return orderDTO;
    }
}
