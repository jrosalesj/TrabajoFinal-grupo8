package boleta;

public interface BaseDatos {
    void GuardarIDProducto(int ID);
    void GuardarNombreProducto(String nombreProducto);
    void GuardarPrecioProducto(String precioProducto);
}
