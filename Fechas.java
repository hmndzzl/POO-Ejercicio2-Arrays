import java.time.LocalDateTime;

public class Fechas {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Fechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

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

    public boolean coinciden(Fechas otraReserva) {
        return (fechaInicio.isBefore(otraReserva.getFin()) && fechaFin.isAfter(otraReserva.getInicio()));
    }
}