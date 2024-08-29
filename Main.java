//
// Programación orientada a objetos
// Sección 20
// Ejercicio 1
// 
// Hugo Méndez - 241265
// Diego Calderón = 241263
//

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Inicializar el sistema e ingresar los datos de 4 salones
        Scanner scanner = new Scanner(System.in);
        // for (int i = 0; i < 4; i++) {
        //     System.out.print("Ingrese el nombre del salón %i: ", i + 1);
        //     String nombreSalon = scanner.nextLine();

        //     int numSalon = 0;
        //     do {
        //         if (numSalon < 0) {
        //             System.out.println("Debe ingresar un valor entero positivo, intente de nuevo.");
        //         }
        //         System.out.print("Ingrese el número de identificación del salón %i: ", i + 1);
        //         numSalon = scanner.nextInt();
        //     } while (numSalon < 0);

        // }
        
        int control = 0;
        while (control == 0){
            System.out.println("¿Desea hacer una resevación de salón? Si: 1 | No: 2");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                default:
                    System.out.println("Error, ingrese una opción válida.");
            }
            
        }

        // Realizar un menú
        // Recibir una solicitud de reserva
        // Asignar un salón a un evento
        // Implementar lógica para gestionar la lista de espera
        // Implementar lófica para verificar conlfictos de horario
        // Generar reportes de eventos
    }
}