
package juegomemoria;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Inicio extends JPanel {
    private Image fondo;
    private JFrame frame =new JFrame ();
    private JLabel txtJugador1;
    private JLabel txtJugador2;
    private JTextField Jugador1;
    private JTextField Jugador2;
    private JButton Jugar;
    private Font fuente=new Font("Castellar",Font.BOLD,15);
    private String nombre1;
    private String nombre2;
    
    public Inicio() {
        setPreferredSize(new Dimension(800,600));
        
        try{
 
            ImageIcon image=new ImageIcon(getClass().getResource("/Images/Fond.png"));
            fondo=image.getImage();
        }catch (Exception e){
            System.out.println("Error en la ruta de imagen"+ e.getMessage());
        }
        iniciarComponentes();
        
        Jugar.addActionListener(e -> {
        nombre1 = Jugador1.getText();
        nombre2 = Jugador2.getText();

    if (nombre1==null || nombre2==null) {
        JOptionPane.showMessageDialog(this, "Por favor ingresa ambos nombres.");
        return;};
        
        frame.dispose();
        Tablero ventanaJuego = new Tablero(nombre1, nombre2);
        ventanaJuego.mostrar();
        });
    }
        
        protected void paintComponent (Graphics g){
            
            super.paintComponent(g);
            if(fondo!=null){
                g.drawImage(fondo, 0, 0, getWidth(),getHeight(),this);
            }
        }
        
    private void iniciarComponentes(){
        setLayout(new GridBagLayout());
        txtJugador1 = new JLabel("Ingrese el nombre del jugador 1:");
        Jugador1 = new JTextField(15);

        txtJugador2 = new JLabel("Ingrese el nombre del jugador 2:");
        Jugador2 = new JTextField(15);

        Jugar = new JButton("Jugar");
        txtJugador1.setForeground(Color.WHITE);
        txtJugador2.setForeground(Color.WHITE);
        txtJugador1.setFont(fuente);
        txtJugador2.setFont(fuente);
        txtJugador1.setOpaque(true);
        txtJugador2.setOpaque(true);
        txtJugador1.setBackground(new Color(0, 0, 0, 160));
        txtJugador2.setBackground(new Color(0, 0, 0, 160));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.gridx = 0;

        gbc.gridy = 0;
        add(txtJugador1, gbc);

        gbc.gridy = 1;
        add(Jugador1, gbc);

        gbc.gridy = 2;
        add(txtJugador2, gbc);

        gbc.gridy = 3;
        add(Jugador2, gbc);

        gbc.gridy = 4;
        add(Jugar, gbc);
    }
    private JFrame crearVentana(){
           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        return frame;
    }
    public void mostrar(){
        JFrame frame=crearVentana();
        frame.setVisible(true);
    }
    
}
