package prepedu.com.springbootdemo2.dto;

import lombok.Data;

@Data
public class CheckoutSuccessMessageDTO {
    private String message;

    public CheckoutSuccessMessageDTO(String message) {
        this.message = message;
    }
}
