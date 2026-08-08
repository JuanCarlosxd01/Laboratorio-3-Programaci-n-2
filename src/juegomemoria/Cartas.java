package juegomemoria;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public abstract class Cartas{
    protected BufferedImage imagen;
    protected BufferedImage imagenAtras;
    protected boolean estaOculta;
    protected int idCarta;

    public void ocultar(){
        estaOculta=true;
    }

    public void revelar(){
        estaOculta=false;
    }

    public boolean estaOculta(){
        return estaOculta;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void cargarImagenes(String nombre) {
        try {
            this.imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/" + nombre + ".png"));
            this.imagenAtras = ImageIO.read(getClass().getResourceAsStream("/imagenes/atras.png"));
        } catch (IOException | NullPointerException e) {
            System.out.println("Error cargando imagen para la pieza: " + nombre);
            e.printStackTrace();
        }
    }

    public BufferedImage getImagen() {
        return estaOculta ? imagenAtras : imagen;
    }

    public abstract boolean coincide(Cartas otra);
}
