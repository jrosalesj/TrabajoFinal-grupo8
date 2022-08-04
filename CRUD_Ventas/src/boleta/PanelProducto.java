
package boleta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


public class PanelProducto extends JFrame implements BaseDatos{
    public LGPanelProducto pLG =new LGPanelProducto();
    public SONYPanelProducto pSONY =new SONYPanelProducto();
    
    public PanelProducto(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JPanel piePanel = new JPanel();
        JLabel pieLbl = new JLabel("©2022 Development Team");
        piePanel.add(pieLbl);
        piePanel.setBounds(0, 340, 385, 25);
        this.add(piePanel);
        
        
    JLabel jLblTitulo = new JLabel("Que Marca desea Registrar");
        jLblTitulo.setOpaque(true);
      
        jLblTitulo.setFont(new Font("Tahoma", 1, 17));
        jLblTitulo.setForeground(Color.BLACK);
        jLblTitulo.setBounds(70, 50, 350, 20);
        this.add(jLblTitulo);
        
       
        JButton SONYboton = new JButton("Marca SONY");
        SONYboton.setBackground(new Color(255, 204, 102));
        SONYboton.setFont(new Font("Tahoma", 1, 14));
        SONYboton.setForeground(new Color(255, 255, 255));
        SONYboton.setBorder(new SoftBevelBorder(BevelBorder.RAISED) );
      
        SONYboton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SONYbotonActionPerformed(e);
            }
        });
        SONYboton.setBounds(130, 130, 110, 30);
        this.add(SONYboton);
        
       
        JButton LGboton = new JButton("Marca LG");
        LGboton.setBackground(new Color(255, 204, 102));
        LGboton.setFont(new Font("Tahoma", 1, 14));
        LGboton.setForeground(new Color(255,255,255));
        LGboton.setBorder(new SoftBevelBorder(BevelBorder.RAISED) );
        LGboton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LGbotonActionPerformed(e);
               
            }
        });
        LGboton.setBounds(130, 200, 110, 30);
        add(LGboton);
}
     private void LGbotonActionPerformed(ActionEvent e){
        System.out.println("Ir a productos LG.");
        
        pLG.setVisible(true);
        pLG.setLocationRelativeTo(null);
        
    }
     private void SONYbotonActionPerformed(ActionEvent e){
        System.out.println("Ir a productos SONY.");
        
        pSONY.setVisible(true);
       pSONY.setLocationRelativeTo(null);
    }
     
      @Override
    public void GuardarIDProducto(int ID){
        System.out.println("El id: " + ID + " se ha guardado enla base de datos.");
    }
    
    public void GuardarNombreProducto(String nombreProducto){
        System.out.println("El nombre: " + nombreProducto+ " se ha guardado enla base de datos.");
    }
    
    public void GuardarPrecioProducto(String precioProducto){
        System.out.println("El precio: " +precioProducto + " se ha guardado enla base de datos.");
        
    }
}