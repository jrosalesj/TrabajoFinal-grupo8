
package datos;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteDatosTest {
    Cliente c1 = new Cliente(1,"Juan","852");
    Cliente c2 = new Cliente(2,"Frank","963");
    Cliente c3 = new Cliente(3,"Fargan","741");
    Cliente c4 = new Cliente(4,"Samuel","123"); 
    ClienteDatos instancia = new ClienteDatos();
    
    @Test
    public void testGetListaClientes() {
        System.out.println("Prueba de getListaClientes --> ");
        instancia.crearCliente(c3);
        int expResult = 3;
        int resultado= instancia.getListaClientes().get(0).getId();
        assertEquals(expResult, resultado);
        System.out.println("");
    }
   
    @Test
    public void testCrearCliente() {
        System.out.println("Prueba de crearCliente --> ");
        instancia.crearCliente(c1);
        instancia.crearCliente(c2);
        int expResult = 2;
        int cantidad = instancia.getListaClientes().size();
        assertEquals(expResult, cantidad);
        System.out.println("");
    }

    @Test
    public void testBorrarCliente() {
        System.out.println("Prueba borrar un cliente mediante un objeto --> ");
        instancia.crearCliente(c1);
        instancia.crearCliente(c2);
        instancia.crearCliente(c3);
        instancia.crearCliente(c4);
        instancia.borrar(c3);
        int expResult = 3;
        int cantidad = instancia.getListaClientes().size();
        assertEquals(expResult, cantidad);
        System.out.println("");
    }

    @Test
    public void testBorrarID() {
        System.out.println("Prueba borrar un cliente mediante su ID --> ");
        instancia.crearCliente(c1);
        instancia.crearCliente(c2);
        int id = c1.getId();
        instancia.borrar(id);
        int expResult = 1;
        int cantidad = instancia.getListaClientes().size();
        assertEquals(expResult, cantidad);
        System.out.println("");
    }
    
}
