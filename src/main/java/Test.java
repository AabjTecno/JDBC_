
import java.sql.*;

public class Test { 
        /*
            PASOS PARA CONECTARSE A MYSQL 
        */
    public static void main(String[] args) { 
        var url ="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";  
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");// No es requerido  
            
            Connection conexion = DriverManager.getConnection(url,"root" ,"admin");
            // esto nos va permitir hacer las sentencia SQL (INSERTAR , ACTUALIZAR , ELIMINAR ,SELECIONAR )
            Statement instrucion = conexion.createStatement();  
            
            var sql ="SELECT id_persona , nombre , apellido ,email ,telefono FROM persona";
            ResultSet resultado =instrucion.executeQuery(sql);  
            
            while (resultado.next()){// mientras haya contenido se va iterar y si no hay regresa false
                System.out.print("ID Persona :"+resultado.getInt("id_persona"));
                System.out.print(" Nombre: "+resultado.getString("nombre")); 
                System.out.print(" Apellido: "+resultado.getString("apellido")); 
                System.out.print(" Email: "+resultado.getNString("email")); 
                System.out.print(" Telefono: "+resultado.getString("telefono")); 
                System.out.println("");
                
            } 
            /*
        IMPORTANTE TENEMOS QUE CERRAR CADA UNO DE LOS OBJETOS QUE HEMOS CREADOS
            DE MANERA INVERSA EJEMPLO : SI CREAMOS LOS OBJETOS DE ESTE ORDEN :  
            CONEXION , INSTRUCION Y RESULTADO . 
            de manera Inversa :  
            RESULTADO , INSTRUCION , CONEXION.
        */
            
        resultado.close();
        instrucion.close();
        conexion.close();
            
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }

    }
}
