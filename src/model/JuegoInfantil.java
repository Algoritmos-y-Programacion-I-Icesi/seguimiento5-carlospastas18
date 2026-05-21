package model;

public class JuegoInfantil extends Atraccion {

    private int edadMaximaAnios;
    private boolean supervisionPermanente;

    public JuegoInfantil(String nombre, String zonaUbicacion, int capacidadMaxima,
                         int edadMinimaAnios, int visitantesPorDia, double precioEntrada,
                         int edadMaximaAnios, boolean supervisionPermanente) {
        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);
        this.edadMaximaAnios = edadMaximaAnios;
        this.supervisionPermanente = supervisionPermanente;
    }

    @Override
    public double calcularIngresoDiario() {
        double ingreso = visitantesPorDia * precioEntrada;
        if (supervisionPermanente) {
            ingreso += visitantesPorDia * 50000;
        }
        return ingreso;
    }

    @Override
    public boolean requiereMantenimiento() {
        return !supervisionPermanente || visitantesPorDia > capacidadMaxima;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTipo          : Juego Infantil" +
               "\nEdad maxima   : " + edadMaximaAnios + " anios" +
               "\nSupervision   : " + (supervisionPermanente ? "Si" : "No") +
               "\nNivel riesgo  : No aplica";
    }

    public int getEdadMaximaAnios() { return edadMaximaAnios; }
    public boolean isSupervisionPermanente() { return supervisionPermanente; }
}