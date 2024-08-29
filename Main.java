import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // // Inicializar el sistema e ingresar los datos de 4 salones
        // Salon[] salones = new Salon[4];

        // boolean invalido = true;
        // String tipoSalon = "";
        // String nombreSalon;
        // int capSalon;
        // int costoSalon;

        // // Crear una instancia de la clase Scanner
        // Scanner scanner1 = new Scanner(System.in);

        // // Mensaje para los empleados del centro (usuarios del sistema)
        // System.out.println("A continuación deberá ingresar los datos de 4 salones
        // disponibles para ser reservados: ");

        // for (int i = 1; i < 5; i++) {
        // // Pedir el nombre del salón al usuario
        // System.out.printf("Ingrese el nombre del salón %d: ", i);
        // nombreSalon = scanner1.nextLine();

        // // Pedir la capacidad del salón al usuario
        // do {
        // System.out.printf("Ingrese la capacidad máxima del salón %d: ", i);
        // capSalon = scanner1.nextInt();
        // scanner1.nextLine(); // Consumir el salto de línea restante

        // if (capSalon >= 500) {
        // tipoSalon = "Grande";
        // } else if (capSalon < 500 && capSalon > 200) {
        // tipoSalon = "Mediano";
        // } else if (capSalon <= 200 && capSalon > 0) {
        // tipoSalon = "Pequeño";
        // } else {
        // System.out.println("Capacidad inválida. Vuelva a intentarlo.");
        // continue;
        // }

        // invalido = false;
        // } while (invalido);

        // invalido = true;
        // do {
        // System.out.printf("Ingrese el costo por hora del salón %d: ", i);
        // costoSalon = scanner1.nextInt();
        // scanner1.nextLine(); // Consumir el salto de línea restante

        // if (costoSalon < 0) {
        // System.out.println("Costo inválido. Ingrese un valor positivo.");
        // continue;
        // }

        // invalido = false;
        // } while (invalido);

        // // Agregar los salones al Array
        // salones[i - 1] = new Salon(nombreSalon, tipoSalon, capSalon, costoSalon); //
        // El número de salón es su index
        // }

        // // Cerrar el scanner
        // scanner1.close();

        // //
        // ---------------------------------------------MENÚ------------------------------------------------

        // // Imprimir los salones
        // for (int j = 0; j < salones.length; j++) {
        // System.out.printf("Nombre: %s | Tipo: %s | Capacidad: %d | Costo: %d |
        // Número: %d\n",
        // salones[j].getNombre(), salones[j].getTipo(), salones[j].getCapacidad(),
        // salones[j].getCosto(), j);
        // }

        // Realizar un menú
        boolean wmenu = true;

        String menu = """
                    Ingrese el número correspondiente al valor de la opción que desea ejecutar:

                    1) Recibir solicitud de reserva.
                    2) Imprimir información de Salones.
                    3) Asignar salón a un evento.
                    4) Generar reportes de eventos.
                    5) Salir.
                """;

        Scanner scanner2 = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(menu);
            System.out.print("Opción: ");

            opcion = scanner2.nextInt();
            scanner2.nextLine();

            // Verificar que el usuario ingrese una opción dentro de las posibles.
            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción incorrecta. Ingrese un número entre 1 y 5.");
                continue;
            }

            // Recibir solicitud de reserva
            if (opcion == 1) {

            }

            // Salir
            if (opcion == 5) {
                System.out.println("Saliendo...");
                wmenu = false;
            }

        } while (wmenu == true);

        scanner2.close();

        // Recibir una solicitud de reserva
        // Asignar un salón a un evento
        // Implementar lógica para gestionar la lista de espera
        // Implementar lófica para verificar conlfictos de horario
        // Generar reportes de eventos
    }
}