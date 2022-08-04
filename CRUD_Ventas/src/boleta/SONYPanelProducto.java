
package boleta;

import datos.Productos;
import datos.ProductosDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SONYPanelProducto extends JFrame implements ProductosFactory{
    public JPanel SONYproductoPanel = new JPanel();
    
    int productoId=0;
    
    ProductosDatos productosDatos = new ProductosDatos();
    String[] productosColumnas = {"ID", "Producto", "Precio"};
    String[][] productosMatriz = new String[0][productosColumnas.length];
    DefaultTableModel modelo2 = new DefaultTableModel(productosMatriz, productosColumnas);
    JTable productoTabla = new JTable(modelo2);
    JScrollPane productoSP = new JScrollPane();
    
      JTextField productoTxtNombre;
      JTextField productoTxtPrecio;
    public SONYPanelProducto(){
        
        this.setSize(450,600);
        
      
        SONYproductoPanel.setLayout(new BoxLayout(SONYproductoPanel, BoxLayout.Y_AXIS));
        JLabel productoLblNombre = new JLabel("Ingrese el nombre del producto SONY: ");
         productoTxtNombre = new JTextField();
        JLabel productoLblPrecio = new JLabel("Ingrese el precio del producto SONY: ");
         productoTxtPrecio = new JTextField();
        
        JButton botonAdd2 = new JButton("Agregar");
        JButton botonRemove2 = new JButton("Remove");
        
        productoSP.setViewportView(productoTabla);
        SONYproductoPanel.add(productoLblNombre);
        SONYproductoPanel.add(productoTxtNombre);
        SONYproductoPanel.add(productoLblPrecio);
        SONYproductoPanel.add(productoTxtPrecio);
        SONYproductoPanel.add(botonAdd2);
        SONYproductoPanel.add(botonRemove2);
        SONYproductoPanel.add(productoSP);   
        
        this.add(SONYproductoPanel);
        this.setLocationRelativeTo(null);
        botonAdd2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                añadirProducto();
            }
        });
        
        botonRemove2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removerProducto();
            }
        });
    }
                
    public void añadirProducto(){
        productoId++;
                Productos p = new Productos(productoId,productoTxtNombre.getText(),productoTxtPrecio.getText());
                productosDatos.crearProducto(p);
                
                productoTxtNombre.setText(""); 
                productoTxtPrecio.setText("");  
                
                List<Productos> miLista = productosDatos.getListaProductos();
                productosMatriz = new String[miLista.size()][productosColumnas.length];
                for(int i=0;i<miLista.size();i++){
                    productosMatriz[i][0]= miLista.get(i).getId() + "";
                    productosMatriz[i][1]= miLista.get(i).getNombreProducto() + "(SONY)";
                    productosMatriz[i][2]= miLista.get(i).getPrecioProducto() + "";
                }
                modelo2 = new DefaultTableModel(productosMatriz, productosColumnas);
                productoTabla = new JTable(modelo2); 
                productoSP.setViewportView(productoTabla); 
    }

    public void removerProducto(){
         if(productoTabla.getSelectedRow() != -1){
                    String ids = null;
                    int[] fila = productoTabla.getSelectedRows();
                    ids = (String) productoTabla.getValueAt(fila[0],0);
                    System.out.println("El elemento seleccionado es : "+ids);
                    int id= Integer.parseInt(ids);
                    productoTxtNombre.setText("" + id);
                    
                    modelo2.removeRow(productoTabla.getSelectedRow()); 
                    try{
                        productosDatos.borrar(id);
                    }catch(java.util.ConcurrentModificationException event){
                        System.out.println("No concuerda con lo ingresado..."+event);
                    }
                    JOptionPane.showMessageDialog(null, "La fila seleccionada fue borrada satisfactoriamente");
                }
    }
}
