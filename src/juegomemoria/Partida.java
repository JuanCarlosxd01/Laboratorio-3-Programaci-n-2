
package juegomemoria;

public class Partida {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorTurno;

    private Cartas primeraCarta;
    private Cartas segundaCarta;

    private int paresEncontrados;
    private int totalParejas;

    private boolean partidaTerminada;

    public Partida(Jugador jugador1, Jugador jugador2, int totalParejas) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorTurno = jugador1;
        this.totalParejas = totalParejas;
        this.paresEncontrados = 0;
        this.primeraCarta = null;
        this.segundaCarta = null;
        this.partidaTerminada = false;
    }


    public void cambiarTurno() {

        if (jugadorTurno == jugador1) {
            jugadorTurno = jugador2;
        } else {
            jugadorTurno = jugador1;
        }
    }


    public boolean seleccionarCarta(Cartas carta) {
        if (partidaTerminada) {
            return false;
        }
        if (carta == null) {
            return false;
        }
        if (carta.estaEmparejada()) {
            return false;
        }
        if (primeraCarta == null) {
            primeraCarta = carta;
            primeraCarta.mostrar();
            return true;
        }
        if (segundaCarta == null && carta != primeraCarta) {

            segundaCarta = carta;
            segundaCarta.mostrar();
            return true;
        }
        return false;
    }

    public boolean comprobarPareja() {
        if (primeraCarta == null || segundaCarta == null) {
            return false;
        }
        if (primeraCarta.esPareja(segundaCarta)) {
            primeraCarta.setEmparejada(true);
            segundaCarta.setEmparejada(true);
            jugadorTurno.sumarAciertos();
            paresEncontrados++;
            limpiarTurno();
            finPartida();
            return true;
        }
        return false;
    }

    public void cartasNoCoinciden() {
        if (primeraCarta == null || segundaCarta == null) {
            return;
        }
        primeraCarta.ocultar();
        segundaCarta.ocultar();
        limpiarTurno();
        cambiarTurno();
    }

    private void limpiarTurno() {
        primeraCarta = null;
        segundaCarta = null;
    }


    private void finPartida() {
        if (paresEncontrados == totalParejas) {
            partidaTerminada = true;
        }
    }


    public Jugador obtenerGanador() {
        if (!partidaTerminada) {
            return null;
        }
        if (hayEmpate()) {
            return null;
        }
        if (jugador1.getAciertos() > jugador2.getAciertos()) {
            return jugador1;
        }
        return jugador2;
    }

    public boolean hayEmpate() {
        if (!partidaTerminada) {
            return false;
        }
        return jugador1.getAciertos() == jugador2.getAciertos();
    }
}
