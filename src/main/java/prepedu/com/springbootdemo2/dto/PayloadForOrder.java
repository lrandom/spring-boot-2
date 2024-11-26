package prepedu.com.springbootdemo2.dto;

import lombok.Data;

import java.util.List;

@Data
public class PayloadForOrder {
    OrderDTO orderInfo;
    List<OrderDetailDTO> productList;
}
