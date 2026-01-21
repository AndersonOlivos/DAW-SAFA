public interface Vuelo {

    //CODIGO

    public String getCodigo();

    //DESTINO

    public String getDestino();

    //PRECIO

    public Double getPrecio();
    public void setPrecio(Double precio);

    //PLAZAS

    public Integer getPlazas();

    //PASAJEROS

    public Integer getPasajeros();
    public void setPasajeros(Integer pasajeros);

    //SALIDA

    public Fecha getSalida();

    //PILOTO

    public Persona getPiloto();
    public void setPiloto(Persona piloto);

}
