package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.UserDetails;

public class UsersDao {

    public static long insertUser(UserDetails user) {
        long id = 0;
        
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webappform"
                , "postgres", "admin")) {
 
            System.out.println("Connected to DB");
            String SQL = "INSERT INTO users(first_name,last_name,email,address,phone) "
                    + "VALUES(?,?,?,?,?)";
     

           PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setString(1, user.getFirstName());
                pstmt.setString(2, user.getLastName());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getAddress());
                pstmt.setString(5, user.getPhone());

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    // get the ID back
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            id = rs.getLong(1);
                        }
                    } catch (SQLException ex) {
                        id = -1;
                        System.out.println(ex.getMessage());
                    }
                }
 
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            id = -11;
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        
        return id;
    }

}
