package prepedu.com.springbootdemo2.models;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private float price;
    private String category;
}
