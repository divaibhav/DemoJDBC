import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/carsales";
            String user = "root";
            String pass = "admin";
            Connection connection = DriverManager.getConnection(url,user,pass);
            if(connection != null){
                System.out.println("connection success");
                //statement
                Statement st = connection.createStatement();
                String sql = "Insert into salesperson values (1050,'Rakes','Bhopal', 50)";
                int rows = st.executeUpdate(sql);
                if(rows == 1){
                    System.out.println("data inserted");
                }else {
                    System.out.println("not inserted");
                }
            }
            else{
                System.out.println("not connected");
            }

        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
