
package boleta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class Boleta extends JFrame {
    public PanelCliente pc=new PanelCliente();
    public PanelProducto p1 = new PanelProducto();
    
    public Boleta(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        initcomponet();
    }
    
    public static void main(String[] args) {
     
        Boleta boleta = new Boleta();
        boleta.setVisible(true);
    }
    
    private void botonContactoActionPerformed(ActionEvent e){
        System.out.println("Ir a contactos.");
        
        
        pc.setVisible(true);
       this.setLocationRelativeTo(null);
    }
    private void botonProductosActionPerformed(ActionEvent e){
        System.out.println("Ir a productos.");
        
        p1.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
    private void botonSalidaActionPerformed(ActionEvent e){
        System.out.println("ADIOS");
        System.exit(0);
    }
    


    private void initcomponet() {
    JLabel jLblTitulo = new JLabel("Bienvenido a su tienda/almacen virtual");
        jLblTitulo.setOpaque(true);
        jLblTitulo.setFont(new Font("Tahoma", 1, 17));
        jLblTitulo.setForeground(Color.BLACK);
        jLblTitulo.setBounds(22, 50, 350, 20);
        this.add(jLblTitulo);
        
        
        JButton botonContacto = new JButton("Contactos");
        botonContacto.setBackground(new Color(255, 204, 102));
        botonContacto.setFont(new Font("Tahoma", 1, 14));
        botonContacto.setForeground(new Color(255, 255, 255));
        botonContacto.setBorder(new SoftBevelBorder(BevelBorder.RAISED) );
        botonContacto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                botonContactoActionPerformed(e);
            }
        });
        botonContacto.setBounds(130, 130, 110, 30);
        this.add(botonContacto);
        
        
        JButton botonProductos = new JButton("Productos");
        botonProductos.setBackground(new Color(255, 204, 102));
        botonProductos.setFont(new Font("Tahoma", 1, 14));
        botonProductos.setForeground(new Color(255,255,255));
        botonProductos.setBorder(new SoftBevelBorder(BevelBorder.RAISED) );
        botonProductos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                botonProductosActionPerformed(e);
               
            }
        });
        botonProductos.setBounds(130, 200, 110, 30);
        add(botonProductos);
        
     
        JButton botonSalida = new JButton("Salida");
        botonSalida.setBackground(new Color(255, 204, 102));
        botonSalida.setFont(new Font("Tahoma", 1, 14));
        botonSalida.setForeground(new Color(255,255,255));
        botonSalida.setBorder(new SoftBevelBorder(BevelBorder.RAISED) );
        botonSalida.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                botonSalidaActionPerformed(e);
            }
        });
        botonSalida.setBounds(280, 310, 80, 25);
        add(botonSalida);   
        
        
     
        JPanel piePanel = new JPanel();
        JLabel pieLbl = new JLabel("©2022 Development Team");
        piePanel.add(pieLbl);
        piePanel.setBounds(0, 340, 385, 25);
        this.add(piePanel);
    }
  
}
