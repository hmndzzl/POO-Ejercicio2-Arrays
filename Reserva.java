import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Salon salon;
    private Solicitud solicitud;
    private List<Solicitud> solicitudes;

    public Reserva(Salon salon, Solicitud solicitud) {
        this.salon = salon;
        this.solicitud = solicitud;
        this.solicitudes = new ArrayList<>();
    }

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
    public boolean  verificacion(String encargado, String nombre, LocalDateTime inicio, LocalDateTime fin, Boolean vip, float duracion) {
        Solicitud nuevaSolicitud = new Solicitud(encargado, nombre, inicio, fin, vip, duracion);
        for (Solicitud reserva : solicitudes) {
            if (reserva.coinciden(nuevaSolicitud)) {
                return false; // Hay una coincidencia, por lo que no está disponible
            }
        }
        return true; // No hay coincidencias, está disponible
    }
    public void agregarReserva(String encargado, String nombre, LocalDateTime inicio, LocalDateTime fin, Boolean vip, float duracion) {
        if (verificacion(encargado, nombre, inicio, fin, vip, duracion)) {
            solicitudes.add(new Solicitud(encargado, nombre, inicio, fin, vip, duracion));
            System.out.println("Reserva agregada con éxito.");
        } else {
            System.out.println("Error: La reserva coincide con una existente.");
        }
    }



    


}