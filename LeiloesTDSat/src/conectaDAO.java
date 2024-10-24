import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    Connection conn = null;
    
    public Connection connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/repositorios?useSSL=false", "visualizador", "123");
        } 
        catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + e.getMessage());
        }
        return conn;
    }
    
    public void disconnectDB(){
        try{
            conn.close();
        }
        catch(SQLException e){}
    }
}
