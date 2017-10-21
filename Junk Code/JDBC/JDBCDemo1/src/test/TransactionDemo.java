
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionDemo {
    public static void main(String[] args) {
         String url="";
        String driver="";
        String databaseName="";
        String userName="";
        String password="";
        Connection connection=null;
        Statement statement=null;
         Savepoint savepoint1=null;
         url="jdbc:mysql://localhost:3306/";
         driver="com.mysql.jdbc.Driver";
         databaseName="db_aayush";
         userName="aayush";
         password="aayush";
        
         url=url+databaseName;
                 
        try 
        {
            Class.forName(driver);
            connection=DriverManager.getConnection(url, userName, password);
            connection.setAutoCommit(false);
            statement=connection.createStatement();
            statement.executeUpdate("INSERT INTO `db_aayush`.`student` (`id`, `name`, `address`, `class`, `rn`) VALUES ('10', 'hari', 'damak', '11', '1');");
           savepoint1=connection.setSavepoint();
            statement.executeUpdate("INSERT INTO `db_aayush`.`student` (`id`, `name`, `address`, `class`, `rn`) VALUES ('11', 'hari', 'damak', '11', '1');");
            statement.executeUpdate("INSERT INTO `db_aayush`.`student` (`id`, `name`, `address`, `class`, `rn`) VALUES ('7  ', 'hari', 'damak', '11', '1');");
           
        } 
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver not found\t"+ex.getMessage());
        }
        catch(SQLException ex)
            
        {
             try {
                 connection.rollback(savepoint1);
             } catch (SQLException ex1) {
                   System.out.println("Could not roll back transaction");
             }
            System.out.println("SQL Error occured\t"+ex.getMessage());
        }
        finally
        {
            try {
              
                 connection.commit();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Couldn't close resource");
            }
        }
    }
}
