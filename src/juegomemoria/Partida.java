
package juegomemoria;

public class Partida {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;

    private Carta primeraCarta;
    private Carta segundaCarta;

    private int parejasEncontradas;
    private int totalParejas;

    private boolean partidaTerminada;

    public Partida(Jugador jugador1, Jugador jugador2, int totalParejas) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        this.jugadorActual = jugador1;

        this.totalParejas = totalParejas;
        this.parejasEncontradas = 0;

        this.primeraCarta = null;
        this.segundaCarta = null;

        this.partidaTerminada = false;
    }


    public void cambiarTurno() {

        if (jugadorActual == jugador1) {
            jugadorActual = jugador2;
        } else {
            jugadorActual = jugador1;
        }
    }


    public boolean seleccionarCarta(Carta carta) {

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

            jugadorActual.sumarAcierto();

            parejasEncontradas++;

            limpiarSeleccion();

            verificarFin();

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

        limpiarSeleccion();

        cambiarTurno();
    }


    private void limpiarSeleccion() {
        primeraCarta = null;
        segundaCarta = null;
    }


    private void verificarFin() {

        if (parejasEncontradas == totalParejas) {
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
