package ui;

import model.Parque;
import java.util.Scanner;

public class Interfaz {

    private static Parque parque = new Parque("MagicWorld");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("  Bienvenido al Sistema de Gestion MagicWorld");
        System.out.println("=============================================");

        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1: registrarSimuladorVirtual();       break;
                case 2: registrarJuegoInfantil();          break;
                case 3: registrarEspectaculoPirotecnico(); break;
                case 4: registrarVisitantesAtraccion();    break;
                case 5: mostrarIngresosDiarios();          break;
                case 6: mostrarAtraccionesClasifRiesgo();  break;
                case 7: generarReporteOperaciones();       break;
                case 8: generarReporteAlertasCapacidad();  break;
                case 0: System.out.println("\nHasta luego!"); break;
                default: System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n----- MENU PRINCIPAL -----");
        System.out.println("1. Registrar Simulador Virtual");
        System.out.println("2. Registrar Juego Infantil");
        System.out.println("3. Registrar Espectaculo Pirotecnico");
        System.out.println("4. Registrar visitantes");
        System.out.println("5. Ver ingresos diarios");
        System.out.println("6. Ver atracciones con clasificacion de riesgo");
        System.out.println("7. Generar reporte de operaciones");
        System.out.println("8. Generar reporte alertas de capacidad");
        System.out.println("0. Salir");
        System.out.println("--------------------------");
    }

    public static void registrarSimuladorVirtual() {
        System.out.println("\n-- Registrar Simulador Virtual --");
        String nombre    = leerTexto("Nombre de la atraccion: ");
        String zona      = leerTexto("Zona de ubicacion: ");
        int capacidad    = leerEntero("Capacidad maxima (personas): ");
        int edadMinima   = leerEntero("Edad minima permitida (anios): ");
        double precio    = leerDecimal("Precio de entrada ($): ");
        int estaciones   = leerEntero("Numero de estaciones: ");
        boolean anteojos = leerBooleano("Requiere anteojos? (s/n): ");
        parque.agregarSimulador(nombre, zona, capacidad, edadMinima, precio, estaciones, anteojos);
        System.out.println("Simulador registrado exitosamente!");
    }

    public static void registrarJuegoInfantil() {
        System.out.println("\n-- Registrar Juego Infantil --");
        String nombre       = leerTexto("Nombre de la atraccion: ");
        String zona         = leerTexto("Zona de ubicacion: ");
        int capacidad       = leerEntero("Capacidad maxima (personas): ");
        int edadMinima      = leerEntero("Edad minima permitida (anios): ");
        double precio       = leerDecimal("Precio de entrada ($): ");
        int edadMaxima      = leerEntero("Edad maxima permitida (anios): ");
        boolean supervision = leerBooleano("Tiene supervision permanente? (s/n): ");
        parque.agregarJuegoInfantil(nombre, zona, capacidad, edadMinima, precio, edadMaxima, supervision);
        System.out.println("Juego Infantil registrado exitosamente!");
    }

    public static void registrarEspectaculoPirotecnico() {
        System.out.println("\n-- Registrar Espectaculo Pirotecnico --");
        String nombre        = leerTexto("Nombre de la atraccion: ");
        String zona          = leerTexto("Zona de ubicacion: ");
        int capacidad        = leerEntero("Capacidad maxima (personas): ");
        int edadMinima       = leerEntero("Edad minima permitida (anios): ");
        double precio        = leerDecimal("Precio de entrada ($): ");
        int duracion         = leerEntero("Duracion en minutos: ");
        boolean matPeligroso = leerBooleano("Usa material peligroso certificado? (s/n): ");
        parque.agregarEspectaculo(nombre, zona, capacidad, edadMinima, precio, duracion, matPeligroso);
        System.out.println("Espectaculo registrado exitosamente!");
    }

    public static void registrarVisitantesAtraccion() {
        System.out.println("\n-- Registrar visitantes por dia --");
        String nombreAtraccion = leerTexto("Nombre de la atraccion: ");
        int visitantes = leerEntero("Cantidad de visitantes del dia: ");
        if (visitantes < 0) {
            System.out.println("La cantidad de visitantes no puede ser negativa.");
        } else {
            parque.registrarVisitantes(nombreAtraccion, visitantes);
        }
    }

    public static void mostrarIngresosDiarios()         { parque.mostrarIngresosDiarios(); }
    public static void mostrarAtraccionesClasifRiesgo() { parque.mostrarAtraccionesClasifRiesgo(); }
    public static void generarReporteOperaciones()      { parque.generarReporteOperaciones(); }
    public static void generarReporteAlertasCapacidad() { parque.generarReporteAlertasCapacidad(); }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    public static double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido (use punto para decimales).");
            }
        }
    }

    public static boolean leerBooleano(String mensaje) {
        System.out.print(mensaje);
        String r = scanner.nextLine().trim().toLowerCase();
        return r.equals("s") || r.equals("si");
    }
}