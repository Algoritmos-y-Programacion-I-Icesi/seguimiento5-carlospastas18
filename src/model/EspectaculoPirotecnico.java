package model;

public class EspectaculoPirotecnico extends Atraccion implements INivelRiesgo {

    private int duracionMinutos;
    private boolean materialPeligrosoCertificado;

    public EspectaculoPirotecnico(String nombre, String zonaUbicacion, int capacidadMaxima,
                                  int edadMinimaAnios, int visitantesPorDia, double precioEntrada,
                                  int duracionMinutos, boolean materialPeligrosoCertificado) {
        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);
        this.duracionMinutos = duracionMinutos;
        this.materialPeligrosoCertificado = materialPeligrosoCertificado;
    }

    @Override
    public double calcularIngresoDiario() {
        double ingreso = visitantesPorDia * precioEntrada;
        if (materialPeligrosoCertificado) {
            ingreso += ingreso * 0.20;
        }
        return ingreso;
    }

    @Override
    public boolean requiereMantenimiento() {
        return materialPeligrosoCertificado || duracionMinutos > 60;
    }

    @Override
    public String nivelRiesgo() {
        if (materialPeligrosoCertificado) return "ALTO";
        if (duracionMinutos > 60)         return "MEDIO";
        return "BAJO";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTipo          : Espectaculo Pirotecnico" +
               "\nDuracion      : " + duracionMinutos + " min" +
               "\nMat. peligroso: " + (materialPeligrosoCertificado ? "Si" : "No") +
               "\nNivel riesgo  : " + nivelRiesgo();
    }

    public int getDuracionMinutos() { return duracionMinutos; }
    public boolean isMaterialPeligrosoCertificado() { return materialPeligrosoCertificado; }
}