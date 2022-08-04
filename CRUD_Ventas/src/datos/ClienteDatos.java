package datos;

import java.util.ArrayList;
import java.util.List;

public class ClienteDatos {
    List<Cliente> listaClientes = new ArrayList<>();
    
    public List<Cliente> getListaClientes(){
        return listaClientes;
    }
    
      public void crearCliente(Cliente c){
        listaClientes.add(c);
        System.out.println("El cliente "+c.getNombreCliente()+" fue añadido.");
    }
    public void borrar(Cliente c){
        listaClientes.remove(c); 
        System.out.println("El cliente "+c.getNombreCliente()+" fue quitado.");
    }
    
    public void borrar(int id){
        boolean existeC =false;
        for(Cliente c: listaClientes){
            if(id==c.getId()){
                System.out.println("Borrando cliente : "+c.getId()+"\t"+c.getNombreCliente());
                try{
                    listaClientes.remove(c);
                    
                }catch(java.util.ConcurrentModificationException e){
                    System.out.println("No concuerda con lo ingresado... "+e);
                }
                existeC=true;
            }
        }
        if(!existeC){
            System.out.println("El cliente no existe.");
        }
    }
}
