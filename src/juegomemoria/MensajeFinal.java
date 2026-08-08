package juegomemoria;

import javax.swing.JOptionPane;

public class MensajeFinal {

    public static void mostrarResultado(
            Jugador jugador1,
            String tiempoJugador1,
            Jugador jugador2,
            String tiempoJugador2) {

        String resultado;

        if (jugador1.getAciertos() > jugador2.getAciertos()) {
            resultado = "GANADOR: " + jugador1.getUsuario();
        } else if (jugador2.getAciertos() > jugador1.getAciertos()) {
            resultado = "GANADOR: " + jugador2.getUsuario();
        } else {
            resultado = "EMPATE";
        }

        String mensaje =
        "FINAL DE LA PARTIDA\n\n"

                + jugador1.getUsuario() + "\n"
                + "Aciertos: " + jugador1.getAciertos() + "\n"
                + "Tiempo: " + tiempoJugador1 + "\n\n"

                + jugador2.getUsuario() + "\n"
                + "Aciertos: " + jugador2.getAciertos() + "\n"
                + "Tiempo: " + tiempoJugador2 + "\n\n"

                + resultado;

        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Resultado Final",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}