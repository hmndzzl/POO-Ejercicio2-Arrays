public class Reserva {
    private Salon salon;
    private Solicitud solicitud;

    public Reserva(Salon salon, Solicitud solicitud) {
        this.salon = salon;
        this.solicitud = solicitud;
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
    public boolean  verificacion(Solicitud solicitud) {
        boolean valido = true;


        return valido;  

    }


}