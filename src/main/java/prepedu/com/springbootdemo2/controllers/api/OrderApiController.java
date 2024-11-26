package prepedu.com.springbootdemo2.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import prepedu.com.springbootdemo2.dto.*;
import prepedu.com.springbootdemo2.entities.Order;
import prepedu.com.springbootdemo2.entities.Product;
import prepedu.com.springbootdemo2.repositories.OrderDetailRepo;
import prepedu.com.springbootdemo2.repositories.OrderRepo;
import prepedu.com.springbootdemo2.repositories.ProductRepo;

@RestController
public class OrderApiController {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @PostMapping("/api/checkout")
    public CheckoutSuccessMessageDTO checkout(@RequestBody PayloadForOrder dto) {
        System.out.println(dto);
        try {
            Order order = orderRepo.save(dto.getOrderInfo().mapToOrder());
            for (OrderDetailDTO orderDetailDTO : dto.getProductList()) {
                orderDetailDTO.setOrderId(order.getId());
                orderDetailRepo.save(orderDetailDTO.mapToOrderDetail());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Checkout failed");
        }
        return new CheckoutSuccessMessageDTO("Checkout success");
    }
}
