package model;

public class SimuladorRealidadVirtual extends Atraccion implements INivelRiesgo {

    private int numeroEstaciones;
    private boolean requiereAnteojos;

    public SimuladorRealidadVirtual(String nombre, String zonaUbicacion, int capacidadMaxima,
                                    int edadMinimaAnios, int visitantesPorDia, double precioEntrada,
                                    int numeroEstaciones, boolean requiereAnteojos) {
        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);
        this.numeroEstaciones = numeroEstaciones;
        this.requiereAnteojos = requiereAnteojos;
    }

    @Override
    public double calcularIngresoDiario() {
        double ingreso = visitantesPorDia * precioEntrada;
        if (!requiereAnteojos) {
            ingreso -= ingreso * 0.10;
        }
        return ingreso;
    }

    @Override
    public boolean requiereMantenimiento() {
        return numeroEstaciones > 20 || visitantesPorDia > capacidadMaxima;
    }

    @Override
    public String nivelRiesgo() {
        boolean cond1 = requiereAnteojos;
        boolean cond2 = numeroEstaciones > 20;
        if (cond1 && cond2) return "ALTO";
        if (cond1 || cond2)  return "MEDIO";
        return "BAJO";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTipo          : Simulador de Realidad Virtual" +
               "\nEstaciones    : " + numeroEstaciones +
               "\nAnteojos      : " + (requiereAnteojos ? "Si" : "No") +
               "\nNivel riesgo  : " + nivelRiesgo();
    }

    public int getNumeroEstaciones() { return numeroEstaciones; }
    public boolean isRequiereAnteojos() { return requiereAnteojos; }
}