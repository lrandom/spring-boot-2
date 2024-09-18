package prepedu.com.springbootdemo2.db;

import org.springframework.stereotype.Component;
import prepedu.com.springbootdemo2.models.Post;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class PostDAO extends DB {
    public ArrayList<Post> list() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setViewCount(resultSet.getInt("view_count"));
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    public Post get(int id) {
        Post post = new Post();
        try {
            connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM posts WHERE id = " + id);
            while (resultSet.next()) {
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setViewCount(resultSet.getInt("view_count"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    public void updateView(int id) {
        try {
            connection = getConnect();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE posts SET view_count = view_count + 1 WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
