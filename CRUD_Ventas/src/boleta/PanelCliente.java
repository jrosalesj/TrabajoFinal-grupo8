
package boleta;

import datos.Cliente;
import datos.ClienteDatos;
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

public class PanelCliente extends JFrame{
    public JPanel clientePanel = new JPanel();
    
    int clienteId=0;
    ClienteDatos clienteDatos=new ClienteDatos();
    String[] clienteColumnas = {"ID", "Nombre", "Documento"};
    String[][] clienteMatriz = new String[0][clienteColumnas.length];
    DefaultTableModel modelo = new DefaultTableModel(clienteMatriz, clienteColumnas);
    JTable contactoTabla = new JTable(modelo);
    JScrollPane clienteSP = new JScrollPane();
    
    public PanelCliente(){
        this.setSize(450, 600);
        this.setLocationRelativeTo(null);
        //CRUD de contactos
        clientePanel.setLayout(new BoxLayout(clientePanel,BoxLayout.Y_AXIS));
        JLabel clienteLblNombre = new JLabel("Ingrese el nombre del contacto : ");
        JTextField clienteTxtNombre = new JTextField();
        JLabel clienteLblDocumento = new JLabel("Ingrese el numero del documento de identidad : ");
        JTextField clienteTxtDocumento = new JTextField();
        
        JButton botonAdd = new JButton("Agregar");
        JButton botonRemove = new JButton("Remover");
        
        clienteSP.setViewportView(contactoTabla);
        clientePanel.add(clienteLblNombre);
        clientePanel.add(clienteTxtNombre);
        clientePanel.add(clienteLblDocumento);
        clientePanel.add(clienteTxtDocumento);
        clientePanel.add(botonAdd);
        clientePanel.add(botonRemove);
        clientePanel.add(clienteSP);
        this.add(clientePanel);
        
        botonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               clienteId++;
               Cliente c = new Cliente(clienteId,clienteTxtNombre.getText(),clienteTxtDocumento.getText());
               clienteDatos.crearCliente(c);
               clienteTxtNombre.setText(""); //Limpiamos la entrada para el nombre del cliente
               clienteTxtDocumento.setText(""); //Limpieando la entrada para el documento de identidad
               
               
               List<Cliente> miLista = clienteDatos.getListaClientes();
               clienteMatriz = new String[miLista.size()][clienteColumnas.length];
               for(int i=0; i<miLista.size();i++){
                   clienteMatriz[i][0] = miLista.get(i).getId() + "";
                   clienteMatriz[i][1] = miLista.get(i).getNombreCliente() + "";
                   clienteMatriz[i][2] = miLista.get(i).getNumeroDocumento() + "";
               }
               //Volvemos a cargar cada tabla
               modelo = new DefaultTableModel(clienteMatriz,clienteColumnas);
               contactoTabla = new JTable(modelo); //Actualizamos la tabla
               clienteSP.setViewportView(contactoTabla); //Actualizamos de nuevo
           } 
        });
        
        botonRemove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Chequearemos para la fila seleccionada
                if(contactoTabla.getSelectedRow() != -1){
                    String ids = null;
                    int[] fila = contactoTabla.getSelectedRows();
                    ids = (String) contactoTabla.getValueAt(fila[0], 0);
                    System.out.println("El elemento de la tabla seleccionado es : "+ids);
                    int id =  Integer.parseInt(ids);
                    clienteTxtNombre.setText(""+id);
                    
                    //Removemos la fila seleccionada del modelo
                    modelo.removeRow(contactoTabla.getSelectedRow());
                    try{
                        clienteDatos.borrar(id);
                    }catch(java.util.ConcurrentModificationException event){
                        System.out.println("No concuerda con lo ingresado..."+event);
                    }
                    JOptionPane.showMessageDialog(null,"La fila seleccionada fue borrada correctamente.");
                }
            }
        });
    }
}
