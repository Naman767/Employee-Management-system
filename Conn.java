package Employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    public Conn(){
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");              //JDBC driver.
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root"," password ");          //DataBase username,password.
                statement = connection.createStatement();                       //Create and Run statement for connectivity.

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
