
package juegomemoria;


public class Jugador {
    
    private String usuario;
    private int aciertos;
    
    public Jugador(String usuario){
        this.usuario = usuario;
        this.aciertos = 0;
    }
    
    public int getAciertos(){
        return aciertos;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void sumarAciertos(){
        aciertos++;
    }
    
    public String toString(){
        return "Usuario: " + usuario + " - Aciertos: " + aciertos;
    }
}
