
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

public class LGPanelProducto extends JFrame implements ProductosFactory{
    public JPanel LGproductoPanel = new JPanel();
    
    int productoId=0;
    ProductosDatos productosDatosLG = new ProductosDatos();
    String[] productosColumnas = {"ID", "Producto", "Precio"};
    String[][] productosMatriz = new String[0][productosColumnas.length];
    DefaultTableModel modelo2 = new DefaultTableModel(productosMatriz, productosColumnas);
    JTable productoTabla = new JTable(modelo2);
    JScrollPane productoSP = new JScrollPane();
    JTextField productoTxtNombre;
    JTextField productoTxtPrecio;
    
    public LGPanelProducto(){
        this.setSize(450, 600);
        this.setLocationRelativeTo(null);
        
        initComponent();
    }
    
    @Override
    public void agregarProducto(){
        productoId++;
        Productos p = new Productos(productoId,productoTxtNombre.getText(),productoTxtPrecio.getText());
        productosDatosLG.crearProducto(p);

        productoTxtNombre.setText("");
        productoTxtPrecio.setText("");

        List<Productos> miLista = productosDatosLG.getListaProductos();
        productosMatriz = new String[miLista.size()][productosColumnas.length];
        for(int i=0;i<miLista.size();i++){
            productosMatriz[i][0]= miLista.get(i).getId() + "";
            productosMatriz[i][1]= miLista.get(i).getNombreProducto() + "(LG)";
            productosMatriz[i][2]= miLista.get(i).getPrecioProducto() + "";
        }
        modelo2 = new DefaultTableModel(productosMatriz, productosColumnas);
        productoTabla = new JTable(modelo2);
        productoSP.setViewportView(productoTabla);
    }
    
    @Override
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
                productosDatosLG.borrar(id);
            }catch(java.util.ConcurrentModificationException event){
                System.out.println("No concuerda con lo ingresado..."+event);
            }
            JOptionPane.showMessageDialog(null, "La fila seleccionada fue borrada satisfactoriamente");
        }
    }
    
    private void initComponent(){
        LGproductoPanel.setLayout(new BoxLayout(LGproductoPanel, BoxLayout.Y_AXIS));
        JLabel productoLblNombre = new JLabel("Ingrese el nombre del producto LG: ");
        productoTxtNombre = new JTextField();
        JLabel productoLblPrecio = new JLabel("Ingrese el precio del producto LG: ");
        productoTxtPrecio = new JTextField();
        
        JButton botonAdd2 = new JButton("Agregar");
        JButton botonRemove2 = new JButton("Remove");
        
        productoSP.setViewportView(productoTabla);
        LGproductoPanel.add(productoLblNombre);
        LGproductoPanel.add(productoTxtNombre);
        LGproductoPanel.add(productoLblPrecio);
        LGproductoPanel.add(productoTxtPrecio);
        LGproductoPanel.add(botonAdd2);
        LGproductoPanel.add(botonRemove2);
        LGproductoPanel.add(productoSP);   
        this.add(LGproductoPanel);
        
        botonAdd2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                agregarProducto();
            }
        });
        
        botonRemove2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removerProducto();
            }
        });
    }
}
