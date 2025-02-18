import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonajeMarvel personaje1 = new PersonajeMarvelImpl("Peter Parker", "Spider-Man", true, "Sentido arácnido", "Avengers", 10.0);
        PersonajeMarvel personaje2 = new PersonajeMarvelImpl("Tony Stark", "Iron-Man", true, "Genio inventor con armadura avanzada", "Avengers", 10.0);
        PersonajeMarvel personaje3 = new PersonajeMarvelImpl("Erik Lehnsherr", "Magneto", true, "Sentido arácnido", "Avengers", 8.5);
        PersonajeMarvel personaje4 = new PersonajeMarvelImpl("Steve Rogers", "Iron-Man", true, "Genio inventor con armadura avanzada", "Avengers", 9.2);

        Equipo equipo1 = new EquipoImpl("Avengers", new ArrayList<>(List.of(personaje1, personaje2)));
        Equipo equipo2 = new EquipoImpl("X-Men", new ArrayList<>(List.of(personaje3, personaje4)));

        //System.out.println(equipo1.poderDelEquipo());
        //System.out.println(equipo1);
        //equipo1.agregarMiembro(personaje3);
        //System.out.println(equipo1);
        //equipo1.quitarMiembro(personaje1);
        //System.out.println(equipo1);

        //Enfrentamiento enfrentamiento1 = new EnfrentamientoImpl(equipo1, equipo2);
        //enfrentamiento1.simularEnfrentamiento(equipo1, equipo2);
    }
}
