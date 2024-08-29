import java.time.LocalDateTime;

public class Solicitud {
    
    // Atributos
    private String encargado;
    private String nombre;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private boolean vip;

    // Constructor
    public Solicitud(String encargado, String nombre, LocalDateTime inicio, LocalDateTime fin, boolean vip) {
        this.encargado = encargado;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.vip = vip;
    }

    // Setters & Getters
    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getInicio() {
        return this.inicio;
    }

    public void setInicio(LocalDateTime fecha) {
        this.inicio = fecha;
    }
    public LocalDateTime getFin() {
        return this.fin;
    }

    public void setFin(LocalDateTime fecha) {
        this.fin = fecha;
    }

    public boolean getVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    //Función para verificar que las fechas y horas no coincidan
    public boolean coinciden(Solicitud otraReserva) {
        return (inicio.isBefore(otraReserva.getFin()) && fin.isAfter(otraReserva.getInicio()));
    }

}