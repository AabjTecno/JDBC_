
import datos.PersonaDAO;
import domain.Persona;
import java.util.*;
public class TestManejoPersona {
    
    public static void main(String[] args) {
        
        PersonaDAO  personaDao = new PersonaDAO(); 
        
        
        // Insertando un nuevo objeto tipo persona  
        
        Persona personaNueva = new Persona("Ezio", "Auditore","auditoreez@gmail.com", "64123512"); 
        personaDao.insertar(personaNueva); 
        

        // Modificando Registro  
        
        Persona personaModificar = new Persona(2, "Mario", "Gustamante", "mariogust@gmail.com", "65123456");
        personaDao.actualizar(personaModificar);
        
        
        // Eliminar un Registro  
        
        Persona personaEliminar = new Persona (2); 
        personaDao.eliminar(personaEliminar);

        // Mostrando Lista 
        List<Persona>personas = personaDao.selecionar(); 
        
        for (Persona elemento : personas){
            System.out.println("Persona = " + elemento);
        }
        
    }
}
