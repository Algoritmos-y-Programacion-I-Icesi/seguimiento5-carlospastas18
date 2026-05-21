package model;

public abstract class Atraccion {

    protected String nombre;
    protected String zonaUbicacion;
    protected int capacidadMaxima;
    protected int edadMinimaAnios;
    protected int visitantesPorDia;
    protected double precioEntrada;

    public Atraccion(String nombre, String zonaUbicacion, int capacidadMaxima,
                     int edadMinimaAnios, int visitantesPorDia, double precioEntrada) {
        this.nombre = nombre;
        this.zonaUbicacion = zonaUbicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.edadMinimaAnios = edadMinimaAnios;
        this.visitantesPorDia = visitantesPorDia;
        this.precioEntrada = precioEntrada;
    }

    public abstract double calcularIngresoDiario();

    public abstract boolean requiereMantenimiento();

    public boolean superaCapacidad() {
        return visitantesPorDia > capacidadMaxima;
    }

    public String alertaCapacidad() {
        if (superaCapacidad()) {
            int exceso = visitantesPorDia - capacidadMaxima;
            double porcentaje = ((double) exceso / capacidadMaxima) * 100;
            return "ALERTA [" + nombre + "]: " + exceso + " visitantes excedieron el limite. "
                    + String.format("%.1f", porcentaje) + "% de sobreocupacion.";
        }
        return "";
    }

    @Override
    public String toString() {
        return "--------------------------------------------" +
                "\nNombre        : " + nombre +
                "\nZona          : " + zonaUbicacion +
                "\nCapacidad max : " + capacidadMaxima + " personas" +
                "\nEdad minima   : " + edadMinimaAnios + " anios" +
                "\nVisitantes hoy: " + visitantesPorDia +
                "\nPrecio entrada: $" + String.format("%,.2f", precioEntrada) +
                "\nIngreso diario: $" + String.format("%,.2f", calcularIngresoDiario()) +
                "\nMantenimiento : " + (requiereMantenimiento() ? "Si" : "No");
    }

    public void setVisitantesPorDia(int visitantes) { visitantesPorDia = visitantes; }
    public String getNombre() { return nombre; }
    public String getZonaUbicacion() { return zonaUbicacion; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getEdadMinimaAnios() { return edadMinimaAnios; }
    public int getVisitantesPorDia() { return visitantesPorDia; }
    public double getPrecioEntrada() { return precioEntrada; }
}
