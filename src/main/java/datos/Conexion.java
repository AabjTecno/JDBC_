package datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; 
    private static final String JDBC_USER ="root"; 
    private static final String JDBC_PASSWORD ="admin"; 
    
    public static Connection getConnection() throws SQLException{
        return  DriverManager.getConnection(JDBC_URL,JDBC_USER ,JDBC_PASSWORD);  
    }
    
    // Metodo para cerrar  los objetos  
    
    // Cerrar Resultados 
    public static void close (ResultSet rs) throws SQLException{
        rs.close();
    } 
    // Cerrar las sentencias
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    // Cerrar Conexion  
    public static void close (Connection  conn) throws SQLException{
        conn.close();
    }
    
            
           
}
