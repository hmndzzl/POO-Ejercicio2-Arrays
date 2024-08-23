public class Salon {

    // Atributos
    private String nombre;
    private int numero;
    private String tipo;
    private int capacidad;
    private int costo;

    // Constructor
    public Salon(String nombre, int numero, String tipo, int capacidad, int costo) {
        this.nombre = nombre;
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    // Setters & Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}