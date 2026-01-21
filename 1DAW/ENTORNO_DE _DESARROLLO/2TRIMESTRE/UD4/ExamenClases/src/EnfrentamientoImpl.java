import java.util.Objects;

public class EnfrentamientoImpl implements Enfrentamiento{
    private Equipo equipo1, equipo2;

    public EnfrentamientoImpl() {
    }

    public EnfrentamientoImpl(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void simularEnfrentamiento(Equipo equipo1, Equipo equipo2) {

        Double poderEquipo1 = 0.0;
        Double poderEquipo2 = 0.0;

        for(PersonajeMarvel p : equipo1.getMiembros()){
            poderEquipo1 = poderEquipo1 + p.getPoder();
        }

        for(PersonajeMarvel p : equipo2.getMiembros()){
            poderEquipo2 = poderEquipo2 + p.getPoder();
        }

        poderEquipo1 = poderEquipo1 * ((Math.random() + 2.0) - 1.0);
        poderEquipo2 = poderEquipo2 * ((Math.random() + 2.0) - 1.0);

        if(poderEquipo1 > poderEquipo2){
            System.out.println("EQUIPO GANADOR: " + equipo1.getNombreEquipo());
            System.out.println("MIEMBROS DEL EQUIPO GANADOR: ");
            for(PersonajeMarvel p : equipo1.getMiembros()){
                System.out.println("- " + p.getAlias());
            }
        } else if(poderEquipo1 < poderEquipo2){
            System.out.println("EQUIPO GANADOR: " + equipo2.getNombreEquipo());
            System.out.println("MIEMBROS DEL EQUIPO GANADOR: ");
            for(PersonajeMarvel p : equipo2.getMiembros()){
                System.out.println("- " + p.getAlias());
            }
        } else {
            System.out.println("EMPATE");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EnfrentamientoImpl that = (EnfrentamientoImpl) o;
        return Objects.equals(equipo1, that.equipo1) && Objects.equals(equipo2, that.equipo2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipo1, equipo2);
    }

    @Override
    public String toString() {
        return "EnfrentamientoImpl{" +
                "equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                '}';
    }
}
