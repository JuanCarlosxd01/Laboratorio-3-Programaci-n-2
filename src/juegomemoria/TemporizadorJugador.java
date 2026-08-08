
package juegomemoria;

import javax.swing.Timer;
import javax.swing.JLabel;

public class TemporizadorJugador {
    
    private int segundos;
    private Timer temporizador;
    private JLabel cuadroTiempo;
    
    public TemporizadorJugador(JLabel cuadroTiempo){
        
        this.cuadroTiempo = cuadroTiempo;
        this.segundos = 0;
        
        temporizador = new Timer(1000, e-> {segundos ++; actualizarTiempo();});
        actualizarTiempo();
    }
    
    public void iniciar(){
        if(!temporizador.isRunning()){
            temporizador.start();
        }
    }
    public void pausar(){
        temporizador.stop();
    }
    public void reiniciar(){
        temporizador.stop();
        segundos =0;
        actualizarTiempo();
    }
    public int getSegundos(){
    return segundos;
    }
    public String getTiempo(){
        
       int minutos = segundos/60;
       int segundosRes = segundos % 60;
       return String.format("%02d:%02d", minutos, segundosRes);
    }
    public boolean activo(){
        return temporizador.isRunning();
        
    }
    private void actualizarTiempo(){
        cuadroTiempo.setText(getTiempo());
    }
    
}
