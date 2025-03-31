import java.util.List;

public interface Equipo {
    public void agregarMiembro(PersonajeMarvel nuevoMiembro);
    public void quitarMiembro(PersonajeMarvel nuevoMiembro);
    public Double poderDelEquipo();
    public String getNombreEquipo();
    public void setNombreEquipo(String nombreEquipo);
    public List<PersonajeMarvel> getMiembros();
    public void setMiembros(List<PersonajeMarvel> miembros);
}
