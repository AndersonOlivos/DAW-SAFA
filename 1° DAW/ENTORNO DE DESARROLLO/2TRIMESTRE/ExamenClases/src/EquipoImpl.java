import java.util.List;
import java.util.Objects;

public class EquipoImpl implements Equipo {
    private String nombreEquipo; //consultable y modificable
    private List<PersonajeMarvel> miembros; //consultable y modificable

    public void agregarMiembro(PersonajeMarvel nuevoMiembro){
        miembros.add(nuevoMiembro);
    }

    public void quitarMiembro(PersonajeMarvel nuevoMiembro){
        miembros.remove(nuevoMiembro);
    }

    public Double poderDelEquipo(){
        Double media = 0.0;
        for(PersonajeMarvel miembro : miembros){
            media = media + miembro.getPoder();
        }
        return (media / miembros.size());
    }

    public EquipoImpl() {
    }

    public EquipoImpl(String nombreEquipo, List<PersonajeMarvel> miembros) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = miembros;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<PersonajeMarvel> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<PersonajeMarvel> miembros) {
        this.miembros = miembros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EquipoImpl equipo = (EquipoImpl) o;
        return Objects.equals(nombreEquipo, equipo.nombreEquipo) && Objects.equals(miembros, equipo.miembros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEquipo, miembros);
    }

    @Override
    public String toString() {
        String stringMiembros = "";
        for(Integer i = 0; i<miembros.size(); i++){
            if(i==0){
                stringMiembros = stringMiembros + miembros.get(i).getAlias();
            } else {
                stringMiembros = stringMiembros + ", "+miembros.get(i).getAlias();
            }
        }
        return "Equipo " + nombreEquipo + ", miembros: " + stringMiembros + ".";
    }
}
