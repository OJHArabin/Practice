
package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewResult {
     public static void main(String[] args)
    {
        
        String url="";
        String driver="";
        String databaseName="";
        String userName="";
        String password="";
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
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
            statement=connection.createStatement();
          //  statement.executeUpdate("INSERT INTO `db_aayush`.`student` (`id`, `name`, `address`, `class`, `rn`) VALUES ('2', 'hari', 'damak', '11', '1');");
          //  resultSet=statement.executeQuery("select * from student");
            if(resultSet!=null)
            {
                while(resultSet.next())
                {
                System.out.println(resultSet.getInt(1)+"-->"+resultSet.getString(2));
                }
            }
           
        } 
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver not found\t"+ex.getMessage());
        }
        catch(SQLException ex)
            
        {
            System.out.println("SQL Error occured\t"+ex.getMessage());
        }
        finally
        {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Couldn't close resource");
            }
        }
    }
}
