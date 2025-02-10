package Practica5;

public interface Pokemon {
    public Integer getNumero();
    public String getNombre();
    public String getDescripcion();
    public void setDescripcion(String descripcion);
    public Double getAltura();
    public void setAltura(Double altura);
    public Double getPeso();
    public void setPeso(Double peso);
    public Genero getGenero();
    public void setGenero(Genero genero);
    public String getTipo();
}
