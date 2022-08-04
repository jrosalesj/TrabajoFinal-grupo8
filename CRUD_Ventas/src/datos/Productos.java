package datos;

public class Productos {
  
    private int id;
    private String nombreProducto;
    private String precioProducto;
    
    public Productos(int id, String nombreProducto, String precioProducto){
        this.id=id;
        this.nombreProducto=nombreProducto;
        this.precioProducto=precioProducto;
    }
    
   
    public int getId(){
        return id;
    }
    public String getNombreProducto(){
        return nombreProducto;
    }
    public String getPrecioProducto(){
        return precioProducto;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto=nombreProducto;
    }
    public void setPrecioProducto(String precioProducto){
        this.precioProducto=precioProducto;
    }
    
}
