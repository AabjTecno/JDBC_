package domain;

public class Persona {
    private int idPersona ;
    private String nombre ;  
    private String apellido; 
    private String email;  
    private String telefono; 
    
    // Constructor Persona 
    public Persona() {
    }

    
    //Para el caso de que queramos eleminar por el IdPersona 
     
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    //Para insertar un nuevo registro no necesitamos el IdPersona  
    
    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    
    // Si queremos Modificar el registro necesitamos expecificar la ID persona
    //y lo que queremos modificar 

    public Persona(int idPersona, String nombre, String apellido, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    
    // Si Queremos Modificar un registro de forma individual hay que añadir los metodos 
    // Getters and Setters 

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    // Para Imprimir el Estado 
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
        
}
