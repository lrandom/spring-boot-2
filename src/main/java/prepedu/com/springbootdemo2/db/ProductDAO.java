package prepedu.com.springbootdemo2.db;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import prepedu.com.springbootdemo2.models.Product;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class ProductDAO extends DB {
    Statement statement;
    ResultSet resultSet;

    PreparedStatement preparedStatement;


    public boolean create(Product product) {
        try {
            connection = getConnect();
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO products (name, price, category) VALUES (?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Product> list() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            connection = getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products");
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getString("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                product.setCategory(resultSet.getString("category"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean update(Product product) {
        try {
            connection = getConnect();
            preparedStatement = connection.prepareStatement("UPDATE products SET name = ?, price=?, category =? WHERE id = ?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setString(4, product.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        try {
            connection = getConnect();
            preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Product find(String id) {
        Product product = new Product();
        try {
            connection = getConnect();
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id = ?");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getString("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                product.setCategory(resultSet.getString("category"));
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
