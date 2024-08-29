import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // // Inicializar el sistema e ingresar los datos de 4 salones
        Salon[] salones = new Salon[4];

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
        boolean wmenu = true;

        String menu = """
                    Ingrese el número correspondiente al valor de la opción que desea ejecutar:

                    1) Imprimir información de Salones.
                    2) Recibir solicitud de reserva.
                    3) Asignar salón a un evento.
                    4) Generar reportes de eventos.
                    5) Salir.
                """;

        int opcion;
        do {
            System.out.println(menu);
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            // Verificar que el usuario ingrese una opción dentro de las posibles.
            if (opcion < 1 || opcion > 5) {
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

                System.out.print("Ingrese el nombre del salón que desea reservar de la siguiente lista: ");
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
                        System.out.println("Valor ingresado incorreco, intente de nuevo.");
                        continue;
                    }
                    w = false;
                } while (w);

                // Revisar si el salón es apto para un evento VIP
                if (salones[index].getCapacidad() >= 500) {
                    vip = true;
                } else {
                    System.out.println("Lo lamentamos, el salón no es apto para un evento VIP.");
                    vip = false;
                }

                // Generar Solicitud
                Solicitud nuevaSolicitud = new Solicitud(encargadoSol, nombreSol, fechaSol, fechaFinSol, vip);
            }

            // Salir
            if (opcion == 5) {
                System.out.println("Saliendo...");
                wmenu = false;
            }

        } while (wmenu == true);

        scanner.close();

        // Recibir una solicitud de reserva
        // Asignar un salón a un evento
        // Implementar lógica para gestionar la lista de espera
        // Implementar lófica para verificar conlfictos de horario
        // Generar reportes de eventos
    }
}