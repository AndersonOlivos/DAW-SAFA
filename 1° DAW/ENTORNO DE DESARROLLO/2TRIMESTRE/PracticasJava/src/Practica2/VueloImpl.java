package Practica2;

public class VueloImpl implements Vuelo{

    private String codigo;
    private String destino;
    private Double precio;
    private Integer plazas;
    private Integer pasajeros;
    private Fecha salida;
    private Double recaudacion;
    private Persona piloto;

    //CONSTRUCTOR

    public VueloImpl(String codigo,String destino,Persona piloto,Fecha salida) {
        this.codigo = codigo;
        this.destino = destino;
        this.salida = salida;
        this.piloto = piloto;
        this.plazas = plazas;
        this.precio = precio;
        this.recaudacion = calcularRecaudacion();
    }

    public Double calcularRecaudacion() {
        // Asegúrate de que precio no sea null antes de usarlo
        if (precio == null || pasajeros == null) {
            return 0.0;
        }
        return precio * pasajeros; // Asumo que "pasajeros" es la base de la recaudación.
    }

    //Código del vuelo: consultable

    public String getCodigo() {
        return codigo;
    }

    //Destino: consultable

    public String getDestino() {
        return destino;
    }

    //Precio: consultable y modificable

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    //Plazas: consultable

    public Integer getPlazas() {
        return plazas;
    }

    //Pasajeros: consultable y modificable

    public Integer getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Integer pasajeros) {
        this.pasajeros = pasajeros;
    }

    //Salida: consultable

    public Fecha getSalida() {
        return salida;
    }

    //Piloto: consultable y modificable

    public Persona getPiloto() {
        return piloto;
    }

    public void setPiloto(Persona piloto) {
        this.piloto = piloto;
    }

    //ToString

    public String toString() {
        return codigo + " ( " + destino + " ) - " + piloto +  " - "+ salida;
    }
}