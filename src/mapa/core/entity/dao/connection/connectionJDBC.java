
package mapa.core.entity.dao.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel
 */
public class connectionJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/mapa";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection conn;
    
    public static Connection getConnection(){
    
        try{
            if(conn == null){
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
            }else{
                return conn;
            }
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Houve um erro ao tentar conectar ao banco de dados.");
            return null;
        }
    }
    
}
