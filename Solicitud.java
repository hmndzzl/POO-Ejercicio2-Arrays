import java.time.LocalDateTime;

public class Solicitud {
    // Atributos
    private String encargado;
    private String nombre;
    private LocalDateTime fecha;
    private boolean vip;
    private float duracion;

    // Constructor
    public Solicitud(String encargado, String nombre, LocalDateTime fecha, boolean vip, float duracion) {
        this.encargado = encargado;
        this.nombre = nombre;
        this.fecha = fecha;
        this.vip = vip;
        this.duracion = duracion;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public boolean getVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

}