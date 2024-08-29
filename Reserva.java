//Importar las librerias necesarias
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    //Atributos
    private Salon salon;
    private Solicitud solicitud;
    private List<Solicitud> solicitudes;

    // Constructor
    public Reserva(Salon salon, Solicitud solicitud) {
        this.salon = salon;
        this.solicitud = solicitud;
        this.solicitudes = new ArrayList<>();
    }

    //Setter & Getters
    public Salon getSalon() {
        return this.salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Solicitud getSolicitud() {
        return this.solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    // Methods

    //Función para verificar que no haya un evento a la hora que se desea reservar 
    public boolean  verificacion(String encargado, String nombre, LocalDateTime inicio, LocalDateTime fin, Boolean vip) {
        Solicitud nuevaSolicitud = new Solicitud(encargado, nombre, inicio, fin, vip);
        for (Solicitud reserva : solicitudes) {
            if (reserva.coinciden(nuevaSolicitud)) {
                return false; // Hay una coincidencia, por lo que no está disponible
            }
        }
        return true; // No hay coincidencias, está disponible
    }




    


}