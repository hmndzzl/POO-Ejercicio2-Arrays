import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializar el sistema e ingresar los datos de 4 salones
        Salon[] salones = new Salon[4];

        boolean invalido = true;
        String tipoSalon = "";
        String nombreSalon;
        int capSalon;
        int costoSalon;

        // Crear una instancia de la clase Scanner
        Scanner scanner = new Scanner(System.in);

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

        // Cerrar el scanner
        scanner.close();

        System.out.println("Length de salones: " + salones.length);

        // Imprimir los salones
        for (int j = 0; j < salones.length; j++) {
            System.out.printf("Nombre: %s | Tipo: %s | Capacidad: %d | Costo: %d | Número: %d\n",
                    salones[j].getNombre(), salones[j].getTipo(), salones[j].getCapacidad(), salones[j].getCosto(), j);
        }
    }
    // Realizar un menú
    // Recibir una solicitud de reserva
    // Asignar un salón a un evento
    // Implementar lógica para gestionar la lista de espera
    // Implementar lófica para verificar conlfictos de horario
    // Generar reportes de eventos
}