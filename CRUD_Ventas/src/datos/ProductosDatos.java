package datos;

import java.util.ArrayList;
import java.util.List;

public class ProductosDatos {
    List<Productos> listaProductos =new ArrayList<>();
    
    public List<Productos> getListaProductos(){
        return listaProductos;
    }
    
    public void crearProducto(Productos p){
        listaProductos.add(p);
        System.out.println("El producto "+p.getNombreProducto()+" fue añadido.");
    }
    
    public void borrar(Productos p){
        listaProductos.remove(p);
        System.out.println("El producto "+p.getNombreProducto()+" fue removido.");
    }
    
    public void borrar(int id){
        boolean existeP = false;
        for(Productos p: listaProductos){
            if(id==p.getId()){
                System.out.println("Borrando producto : "+p.getId()+"\t"+p.getNombreProducto());
                try{
                    listaProductos.remove(p);
                }catch(java.util.ConcurrentModificationException e){
                    System.out.println("No concuerda con lo ingresado..."+e);
                }
                existeP=true;
            }
        }
        if(!existeP){
            System.out.println("El producto no existe");
        }
    }
}
