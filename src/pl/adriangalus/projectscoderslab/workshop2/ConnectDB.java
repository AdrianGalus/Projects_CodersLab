package pl.adriangalus.projectscoderslab.workshop2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    static Connection conn = null;
    
    public static Connection getConnection(String database, String user, String password) throws SQLException {

        if(conn != null) {
            return conn;
        }
        else {
            conn = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s?useTimezone=true&" +
                    "serverTimezone=GMT&useSSL=false&characterEncoding=utf8", database), user, password);
            return conn;
        }
    }
    public static void registerDriver() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
