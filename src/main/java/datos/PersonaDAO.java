package datos;

import static datos.Conexion.*;// Importar todos los metodos staticos
import domain.*;
import java.sql.*;
import java.util.*;

public class PersonaDAO {
    // o SELECT * (QUE SELECIONA TODO)  
    // Es recomedable probar nuestra setencia fuera de java con el query de Mysql 
    
    private static final String SQL_SELECT ="SELECT id_persona,nombre,apellido,email ,telefono FROM test.persona"; 
    private static final String SQL_INSERT ="INSERT INTO persona(nombre,apellido,email,telefono) VALUES(? ,? ,? ,? )";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?,apellido=?,email=?,telefono=? WHERE id_persona=? ";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona =?";
    // vamos a crear un metodo que va regresar una  lista de objeto tipo persona  
    
    public List<Persona>selecionar(){
        
        // vamos a nuestra instruccion  
            Connection conn=null;  
            PreparedStatement stmt =null; 
            ResultSet rs =null;  
            Persona persona=null;  
            
            List<Persona> personas = new ArrayList<>(); 
        try {
            // Import statico si no quieres llamar a la clase  "con = Conexion.getconection"
            conn=getConnection(); 
            stmt = conn.prepareStatement(SQL_SELECT);  
            rs = stmt.executeQuery();  
            
            while (rs.next()){// va iterando las columnas mientras haya registro
                int idPersona  = rs.getInt("id_persona"); 
                String nombre = rs.getString("nombre"); 
                String apellido = rs.getString("apellido"); 
                String email = rs.getString("email"); 
                String telefono = rs.getString("telefono");   
                persona = new Persona (idPersona, nombre, apellido, email, telefono); 
                personas.add(persona);
            } 
            
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }
        finally {
            // Cerramos los Objetos de conexion 
                try { 
                    close(rs); // result.close
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) { 
                    ex.printStackTrace(System.out);
                }
        }
           
        return personas;
    }

    public int insertar(Persona persona ){
        Connection conn = null; 
        PreparedStatement stmt=null;  
        int registro =0 ;   
        
        try {
            conn = getConnection(); 
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registro = stmt.executeUpdate();// hacer la actualizacion 
            
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }
        finally {
            try { 
                close(stmt); 
                close(conn);
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }
        }
        return registro ; 
    } 
    
    
    public int actualizar (Persona persona ){
        Connection conn = null;  
        PreparedStatement stmt=null; 
        
        int registro = 0 ; 
        
        try {
            conn = getConnection(); 
            stmt= conn.prepareStatement(SQL_UPDATE); 
            
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());  
            stmt.setInt(5, persona.getIdPersona());
            registro = stmt.executeUpdate();   
          
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }
        finally{
            try { 
                close(stmt);
                close(conn);
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registro ; 
    }  
    
    public int eliminar (Persona persona ){
        Connection conn = null;  
        PreparedStatement stmt=null; 
        
        int registro = 0 ; 
        
        try {
            conn = getConnection(); 
            stmt= conn.prepareStatement(SQL_DELETE); 
            stmt.setInt(1, persona.getIdPersona());
            registro = stmt.executeUpdate();   
          
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }
        finally{
            try { 
                close(stmt);
                close(conn);
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registro ; 
    }
    
}
