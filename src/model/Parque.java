package model;

import java.util.ArrayList;

public class Parque {

    private String nombre;
    private ArrayList<Atraccion> atracciones;

    public Parque(String nombre) {
        this.nombre = nombre;
        this.atracciones = new ArrayList<>();
    }

    public ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }

    public void agregarSimulador(String nombre, String zona, int capacidad, int edadMin,
                                 double precio, int estaciones, boolean anteojos) {
        atracciones.add(new SimuladorRealidadVirtual(nombre, zona, capacidad, edadMin, 0, precio, estaciones, anteojos));
    }

    public void agregarJuegoInfantil(String nombre, String zona, int capacidad, int edadMin,
                                     double precio, int edadMax, boolean supervision) {
        atracciones.add(new JuegoInfantil(nombre, zona, capacidad, edadMin, 0, precio, edadMax, supervision));
    }

    public void agregarEspectaculo(String nombre, String zona, int capacidad, int edadMin,
                                   double precio, int duracion, boolean materialPeligroso) {
        atracciones.add(new EspectaculoPirotecnico(nombre, zona, capacidad, edadMin, 0, precio, duracion, materialPeligroso));
    }

    public Atraccion buscarAtraccionPorNombre(String nombreAtraccion) {
        for (Atraccion a : atracciones) {
            if (a.getNombre().equalsIgnoreCase(nombreAtraccion)) return a;
        }
        return null;
    }

    public void registrarVisitantes(String nombreAtraccion, int visitantesPorDia) {
        Atraccion encontrada = buscarAtraccionPorNombre(nombreAtraccion);
        if (encontrada == null) {
            System.out.println("No se encontro una atraccion con el nombre: " + nombreAtraccion);
        } else {
            encontrada.setVisitantesPorDia(visitantesPorDia);
            System.out.println("Visitantes registrados para: " + nombreAtraccion);
        }
    }

    public void mostrarIngresosDiarios() {
        System.out.println("\n--- INGRESOS DIARIOS ---");
        double total = 0;
        for (Atraccion a : atracciones) {
            double ingreso = a.calcularIngresoDiario();
            System.out.printf("  %-25s $%,.2f%n", a.getNombre() + ":", ingreso);
            total += ingreso;
        }
        System.out.println("  ----------------------------------------");
        System.out.printf("  %-25s $%,.2f%n", "TOTAL:", total);
    }

    public double calcularIngresoTotalDiario() {
        double total = 0;
        for (Atraccion a : atracciones) total += a.calcularIngresoDiario();
        return total;
    }

    public void generarReporteOperaciones() {
        System.out.println("\n--- REPORTE DE OPERACIONES ---");
        if (atracciones.isEmpty()) {
            System.out.println("No hay atracciones registradas.");
            return;
        }
        for (Atraccion a : atracciones) {
            System.out.println(a.toString());
        }
    }

    public void mostrarAtraccionesClasifRiesgo() {
        System.out.println("\n--- ATRACCIONES CON NIVEL DE RIESGO ---");
        boolean hayAlguna = false;
        for (Atraccion a : atracciones) {
            if (a instanceof INivelRiesgo) {
                INivelRiesgo conRiesgo = (INivelRiesgo) a;
                System.out.println("  " + a.getNombre() + " -> Riesgo: " + conRiesgo.nivelRiesgo());
                hayAlguna = true;
            }
        }
        if (!hayAlguna) System.out.println("  Ninguna atraccion tiene clasificacion de riesgo.");
    }

    public void generarReporteAlertasCapacidad() {
        System.out.println("\n--- ALERTAS DE CAPACIDAD ---");
        boolean hayAlerta = false;
        for (Atraccion a : atracciones) {
            if (a.superaCapacidad()) {
                System.out.println("  " + a.alertaCapacidad());
                hayAlerta = true;
            }
        }
        if (!hayAlerta) System.out.println("  Ninguna atraccion supera su capacidad maxima.");
    }
}