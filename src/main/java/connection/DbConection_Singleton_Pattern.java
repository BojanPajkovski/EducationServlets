package connection;

import java.sql.*;

/**
 * Created by User on 04.09.2018.
 */
public class DbConection_Singleton_Pattern {

    private static DbConection_Singleton_Pattern instance ;

    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rst = null;

    String dbUrl ="jdbc:mysql://localhost:3006/education?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String pass ="root";


    private DbConection_Singleton_Pattern() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbUrl, user, pass);

    }

    static{

        try{

            instance = new DbConection_Singleton_Pattern();

        }
        catch(Exception e){

            throw new RuntimeException("Exception occured in creating singleton instance");

        }
    }



    public static Connection getConnection()  {

        return conn;
    }



}
