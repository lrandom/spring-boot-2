package prepedu.com.springbootdemo2.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    Connection connection;

    public Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbootdemo2", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
