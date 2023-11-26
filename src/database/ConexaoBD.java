package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    
    private static final String url = "jdbc:mysql://localhost:3306/app_java";
    private static final String user = "root";
    private static final String password = "";
    private static Statement statement = null;
    private static Connection connect = null;
    
    public static Connection getConexao(){
        try{
            if ( connect == null){
                connect = DriverManager.getConnection(url, user, password);
                System.out.println("Deu certo");
                return connect;
            }else{
                return connect;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    };
   
    public static void main(String args[]) {
        getConexao();
    }
}
