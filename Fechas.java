import java.time.LocalDateTime; //Importar LocalDateTime para las fechas

public class Fechas {
    private LocalDateTime fechaInicio; //Fecha Inicio
    private LocalDateTime fechaFin; //Fecha Fin

    //Constructor
    public Fechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    //Getters y Setters para las fechas de inicio y fin de la reserva
    public LocalDateTime getInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fecha) {
        this.fechaInicio = fecha;
    }

    public LocalDateTime getFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fecha) {
        this.fechaFin = fecha;
    }
    //Función para verificar que las fechas y horas no coincidan
    public boolean coinciden(Fechas otraReserva) {
        return (fechaInicio.isBefore(otraReserva.getFin()) && fechaFin.isAfter(otraReserva.getInicio()));
    }
}