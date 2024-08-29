//
// Programación orientada a objetos
// Sección 20
// Ejercicio 1
// 
// Hugo Méndez - 241265
// Diego Calderón = 241263
//

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Inicializar el sistema e ingresar los datos de 4 salones
        Salon[] salones = new Salon[4];
        Solicitud[] solicitudes = new Solicitud[10];
        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<Reserva> espera = new ArrayList<>();

        boolean invalido = true;
        String tipoSalon = "";
        String nombreSalon;
        int capSalon;
        int costoSalon;

        // Crear una instancia de la clase Scanner
        Scanner scanner = new Scanner(System.in);

        // Mensaje para los empleados del centro (usuarios del sistema)
        System.out.println("A continuación deberá ingresar los datos de 4 salones disponibles para ser reservados: ");

        for (int i = 1; i < 5; i++) {
            // Pedir el nombre del salón al usuario
            System.out.printf("Ingrese el nombre del salón %d: ", i);
            nombreSalon = scanner.nextLine();

            // Pedir la capacidad del salón al usuario
            do {
                System.out.printf("Ingrese la capacidad máxima del salón %d: ", i);
                capSalon = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea restante

                if (capSalon >= 500) {
                    tipoSalon = "Grande";
                } else if (capSalon < 500 && capSalon > 200) {
                    tipoSalon = "Mediano";
                } else if (capSalon <= 200 && capSalon > 0) {
                    tipoSalon = "Pequeño";
                } else {
                    System.out.println("Capacidad inválida. Vuelva a intentarlo.");
                    continue;
                }

                invalido = false;
            } while (invalido);

            invalido = true;
            do {
                System.out.printf("Ingrese el costo por hora del salón %d: ", i);
                costoSalon = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea restante

                if (costoSalon < 0) {
                    System.out.println("Costo inválido. Ingrese un valor positivo.");
                    continue;
                }

                invalido = false;
            } while (invalido);

            // Agregar los salones al Array
            salones[i - 1] = new Salon(nombreSalon, tipoSalon, capSalon, costoSalon); // El número de salón es su index
        }

        // ---------------------------------------------MENÚ------------------------------------------------
        // Realizar un menú
        int solNum = 0; // Index para el array de solicitudes
        boolean wmenu = true;

        String menu = """
                    Ingrese el número correspondiente al valor de la opción que desea ejecutar:

                    1) Imprimir información de Salones.
                    2) Recibir solicitud de reserva.
                    3) Asignar salón a un evento.
                    4) Generar reporte de eventos.
                    5) Salir.
                """;

        int opcion;
        do {
            System.out.println(menu);
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            // Verificar que el usuario ingrese una opción dentro de las posibles.
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción incorrecta. Ingrese un número entre 1 y 5.");
                continue;
            }

            // Imprimir información de los salones disponibles
            if (opcion == 1) {
                for (int i = 0; i < salones.length; i++) {
                    System.out.printf("Nombre: %s | Tipo: %s | Capacidad: %d | Costo: %d | Número: %d\n",
                            salones[i].getNombre(), salones[i].getTipo(), salones[i].getCapacidad(),
                            salones[i].getCosto(), i);
                }
            } else if (opcion == 2) { // Recibir solicitud de reserva
                System.out.print("Ingrese a nombre de quién se desea realizar la reservación: ");
                String encargadoSol = scanner.nextLine();

                System.out.println("Ingrese el nombre del salón que desea reservar de la siguiente lista: ");
                // Imprimir los salones
                for (int i = 0; i < salones.length; i++) {
                    System.out.printf("Nombre: %s | Tipo: %s | Capacidad: %d | Costo: %d | Número: %d\n",
                            salones[i].getNombre(), salones[i].getTipo(), salones[i].getCapacidad(),
                            salones[i].getCosto(), i);
                }

                String nombreSol = scanner.nextLine().toLowerCase();

                // Verificar que el salón se encuentre en el array
                // Utilizo Do While para no utilizar for - break
                boolean nombreIncorrecto = true;
                int i = 0;
                int index = 0;
                do {
                    if (nombreSol.equalsIgnoreCase(salones[i].getNombre())) {
                        nombreIncorrecto = false;
                        index = i;
                    }
                    i++;
                    if (i >= salones.length) {
                        i = 0;
                    }
                } while (nombreIncorrecto == true && i < salones.length);

                // Solicitar la fecha de reservación en formato LocalDateTime
                System.out.println("Ingrese la fecha de reservación en el siguiente formato: ");
                System.out.println("Año (AAAA): ");
                int anioSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Mes (MM): ");
                int mesSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Día (dd): ");
                int diaSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Hora (HH): ");
                int horaSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Minuto (mm): ");
                int minutoSol = scanner.nextInt();
                scanner.nextLine();

                LocalDateTime fechaSol = LocalDateTime.of(anioSol, mesSol, diaSol, horaSol, minutoSol);

                // Solicitar la fecha de cuando termina el evento (fecha final)
                System.out.println("Ingrese la fecha de terminación de su reservación: ");
                System.out.println("Año (AAAA): ");
                anioSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Mes (MM): ");
                mesSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Día (dd): ");
                diaSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Hora (HH): ");
                horaSol = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Minuto (mm): ");
                minutoSol = scanner.nextInt();
                scanner.nextLine();

                LocalDateTime fechaFinSol = LocalDateTime.of(anioSol, mesSol, diaSol, horaSol, minutoSol);

                // Preguntar si el evento es VIP
                System.out.println("¿Su evento tiene características VIP? (y/n)");
                String respuestaVIP = scanner.nextLine().toLowerCase();
                boolean w = true;
                boolean vip = false;
                do {
                    if (respuestaVIP.equals("y")) {
                        vip = true;
                    } else if (respuestaVIP.equals("n")) {
                        vip = false;
                    } else {
                        System.out.println("Valor ingresado incorrecto, intente de nuevo.");
                        continue;
                    }
                    w = false;
                } while (w);

                // Revisar si el salón es apto para un evento VIP
                if (vip == true) {
                    if (salones[index].getCapacidad() < 500) {
                        System.out.println("Lo lamentamos, el salón no es apto para un evento VIP.");
                        vip = false;
                    }
                }

                // Generar Solicitud
                Solicitud nuevaSolicitud = new Solicitud(encargadoSol, nombreSol, fechaSol, fechaFinSol, vip);

                solicitudes[solNum] = nuevaSolicitud;

                solNum++;

            } else if (opcion == 3) { // Asignar Salón a un evento
                System.out.println("¿Cuál reserva desea agregar a un salón?");
                int contador = 0;

                for (int j = 0; j < solicitudes.length; j++) {
                    Solicitud sol = solicitudes[j];
                    if (sol != null) { // Verificación de que la solicitud no sea null
                        System.out.printf("%d) Encargado: %s | Salón: %s | Fecha: %s - %s | VIP: %s\n",
                                contador, sol.getEncargado(), sol.getNombre(), sol.getInicio(),
                                sol.getFin(), sol.getVip());
                        contador++;
                    }
                }

                int reservar = scanner.nextInt();
                Solicitud evento = solicitudes[reservar];
                Salon salonReserva = new Salon();
                for (Salon salon : salones) {
                    if (salon.getNombre().equals(evento.getNombre())) {
                        salonReserva = salon;
                        break;
                    }
                }

                Reserva eventoReserva = new Reserva(salonReserva, evento);
                if (eventoReserva.verificacion(evento.getEncargado(), evento.getNombre(), evento.getInicio(),
                        evento.getFin(), evento.getVip()) == true) {
                    System.out.println("Reserva realizada exitosamente.");
                    reservas.add(eventoReserva);
                } else {
                    boolean controool = false;
                    while (controool == false) {
                        System.out.println(
                                "Error la fecha y hora para el salón ya están tomadas. ¿Desea agregar el evento a la lista de espera? Si: 1 | No: 2");
                        int opcion2 = scanner.nextInt();
                        switch (opcion2) {
                            case 1:
                                espera.add(eventoReserva);
                                controool = true;
                                break;
                            case 2:
                                System.out.println(
                                        "Entendido, no se guardaran los datos del evento en la lista de espera...");
                                controool = true;
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida.");
                        }
                    }
                }

            } else if (opcion == 4) { // Imprimir listas de reservas
                System.out.println("Lista de Reservas Confirmadas: ");
                if (reservas.isEmpty()) {
                    System.out.println("No hay reservas confirmadas.");
                } else {
                    for (Reserva reserva : reservas) {
                        System.out.printf("Salón: %s | Encargado: %s | Fecha Inicio: %s | Fecha Fin: %s\n",
                                reserva.getSalon().getNombre(), reserva.getSolicitud().getEncargado(),
                                reserva.getSolicitud().getInicio(), reserva.getSolicitud().getFin());
                    }
                }
            } else if (opcion == 5) { // Salir
                System.out.println("Saliendo...");
                wmenu = false;
            }

        } while (wmenu == true);

        scanner.close();
    }
}