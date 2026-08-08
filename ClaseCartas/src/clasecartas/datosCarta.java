package clasecartas;

public class datosCarta extends Cartas {
    private String nombre;

    public datosCarta(int idCarta, String nombre) {
        this.idCarta = idCarta;
        this.nombre = nombre;
        this.estaOculta = true;
        cargarImagenes(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean coincide(Cartas otra) {
        if (!(otra instanceof datosCarta)) {
            return false;
        }
        return this.idCarta == otra.getIdCarta();
    }
}
