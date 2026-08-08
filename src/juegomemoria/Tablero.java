
package juegomemoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.List; 

public class Tablero extends JPanel{
    private static final int filas=6;
    private static final int columnas=6;
    private JFrame frame=new JFrame();
    private JLabel labelJugador1;
    private JLabel labelJugador2;
    private JLabel tiempo;
    private ImageIcon[][] tablero=new ImageIcon[6][6];
    private String [] imagenes={"/Images/1.png","/Images/2.png","/Images/3.png","/Images/4.png","/Images/5.png","/Images/6.png","/Images/7.png","/Images/8.png","/Images/9.png",
     "/Images/10.png", "/Images/11.png", 
    };
    private ImageIcon reves;
    private Font fuente = new Font("Castellar", Font.BOLD, 15);
    private List<ImageIcon> cartas = new ArrayList<>();

    public Tablero(String nombre1, String nombre2) {

        setPreferredSize(new Dimension(800, 800));
        setLayout(new BorderLayout());
        cargarImagenes();
        JPanel superior = new JPanel();
        superior.setLayout(  new FlowLayout( FlowLayout.CENTER, 30, 10) );

        superior.setPreferredSize(new Dimension(600, 40) );

        superior.setOpaque(true);
        superior.setBackground(Color.WHITE);

        labelJugador1 = new JLabel("Jugador 1: " + nombre1);
        labelJugador2 = new JLabel("Jugador 2: " + nombre2);
        tiempo = new JLabel("Tiempo:");

        labelJugador1.setFont(fuente);
        labelJugador2.setFont(fuente);
        tiempo.setFont(fuente);

        superior.add(labelJugador1);
        superior.add(labelJugador2);
        superior.add(tiempo);

        add( superior, BorderLayout.NORTH );

        JPanel panelTablero = new JPanel();

        panelTablero.setLayout(new GridLayout(filas,columnas,5,5));

        panelTablero.setOpaque(false);
        List<Boolean> posiciones = new ArrayList<>();

        for (int i = 0; i < 22; i++) {
            posiciones.add(true);
        }

        for (int i = 0; i < 14; i++) {
            posiciones.add(false);
        }
        Collections.shuffle(posiciones);
        int posicionCarta = 0;
        for (int fila = 0; fila < filas; fila++) {

            for (int columna = 0; columna < columnas; columna++) {
                JButton celda = new JButton();
                celda.setPreferredSize(new Dimension(120, 120));
                celda.setIcon(reves);
                int posicion = fila * columnas + columna;
                if (posiciones.get(posicion)) {
                    tablero[fila][columna] = cartas.get(posicionCarta);
                    final int f = fila;
                    final int c = columna;
                    celda.addActionListener(e -> {
                        celda.setIcon(tablero[f][c]);
                    });
                    posicionCarta++;
                } else {
                    celda.addActionListener(e -> {
                        celda.setIcon(null);
                        celda.setBackground(Color.WHITE);
                    });
                }
                panelTablero.add(celda);
            }
        }

        add(panelTablero,BorderLayout.CENTER);
    }
    
    private void cargarImagenes(){
         reves = new ImageIcon(getClass().getResource("/Images/1.png"));
         Image imagenEscalada = reves.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
         reves = new ImageIcon(imagenEscalada);
         
         for (String ruta : imagenes) { 
             ImageIcon icono = new ImageIcon( getClass().getResource(ruta) ); 
             Image imagen = icono.getImage() .getScaledInstance( 120, 120, Image.SCALE_SMOOTH );
            ImageIcon iconoEscalado = new ImageIcon(imagen);
            cartas.add(iconoEscalado); 
            cartas.add(iconoEscalado);  
         }
         Collections.shuffle(cartas);
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

