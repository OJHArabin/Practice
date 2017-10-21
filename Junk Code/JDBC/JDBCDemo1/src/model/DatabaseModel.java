
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseModel 
{
     String url="";
        String driver="";
        String databaseName="";
        String userName="";
        String password="";
        Connection connection=null;
        Statement statement=null;
        public DatabaseModel()
        {
         url="jdbc:mysql://localhost:3306/";
         driver="com.mysql.jdbc.Driver";
         databaseName="db_aayush";
         userName="aayush";
         password="aayush";
         url=url+databaseName;
        }
        public String connect()
        {
            try 
            {
                Class.forName(driver);
                connection=DriverManager.getConnection(url, userName, password);
                return "Connected";
            } 
            catch (ClassNotFoundException ex)
            {

                return ex.getMessage();
            }
            catch(SQLException ex)

            {
                return ex.getMessage();
            }
        }
        public String authenticateUser(String username,String password) throws SQLException
        {
            String table="login";
            boolean found=false;
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from "+table);
            while(rs!=null&&rs.next())
            {
                if(rs.getString("username").equals(username)&&rs.getString("password").equals(password))
                {
                    found=true;
                    break;
                }
            }
            if(found)
                return "Verified";
            else
                return "Not Verified";
        }
        public void addStudent(Student s) throws SQLException
        {
             statement=connection.createStatement();
             statement.executeUpdate("INSERT INTO `db_aayush`.`student` (`id`, `name`, `address`, `class`, `rn`) VALUES ("+s.getId()+", '"+s.getName()+"', '"+s.getAddress()+"', "+s.getClas()+", "+s.getRn()+");");
             statement.close();
        }
        public Connection getConnection()
        {
            return connection;
        }
}
