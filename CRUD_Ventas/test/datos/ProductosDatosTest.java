
package datos;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductosDatosTest {
    Productos p1 = new Productos(1,"Computador","1230");
    Productos p2 = new Productos(2,"TV","1500");
    Productos p3 = new Productos(3,"Computador","3000");
    ProductosDatos instancia = new ProductosDatos();
            
    @Test
    public void testGetListaProductos() {
        System.out.println("Prueba de getListaProductos --> ");
        instancia.crearProducto(p1);
        int expResult = 1;
        int resultado = instancia.getListaProductos().get(0).getId();
        assertEquals(expResult, resultado);
        System.out.println("");
    }

    @Test
    public void testCrearProducto() {
        System.out.println("Prueba de crearProducto --> ");
        instancia.crearProducto(p1);
        int expResult = 1;
        int cantidad = instancia.getListaProductos().size();
        assertEquals(expResult,cantidad);
        System.out.println("");
    }

    @Test
    public void testBorrarProductos() {
        System.out.println("Prueba de borrar un producto mediante un objeto --> ");
        instancia.crearProducto(p1);
        instancia.crearProducto(p2);
        instancia.crearProducto(p3);
        instancia.borrar(p3);
        int expResult = 2;
        int cantidad = instancia.getListaProductos().size();
        assertEquals(expResult,cantidad);
        System.out.println("");
    }

    @Test
    public void testBorrarID() {
        System.out.println("Prueba de borrar un producto mediante su ID --> ");
        instancia.crearProducto(p1);
        instancia.crearProducto(p2);
        instancia.crearProducto(p3);
        instancia.borrar(p2.getId());
        int expResult = 2;
        int cantidad = instancia.getListaProductos().size();
        assertEquals(expResult,cantidad);
        System.out.println("");
    }
    
}
