package datos;

public class Cliente {
    private int id;
    private String nombreCliente;
    private String numeroDocumento;
    
    public Cliente(int id,String nombreCliente, String numeroDocumento){
        this.id=id;
        this.nombreCliente=nombreCliente;
        this.numeroDocumento=numeroDocumento;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNombreCliente(){
        return nombreCliente;
    }
    
    public String getNumeroDocumento(){
        return numeroDocumento;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setNombre(String nombreCliente){
        this.nombreCliente=nombreCliente;
    }
    
    public void setNumeroDocumento(String numeroDocumento){
        this.numeroDocumento=numeroDocumento;
    }
}
