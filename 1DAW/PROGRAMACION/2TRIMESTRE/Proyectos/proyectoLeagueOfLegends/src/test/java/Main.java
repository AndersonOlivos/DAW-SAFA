import modelos.*;

import java.util.*;
import java.time.LocalDate;

import static utilidades.UtilidadesPersonaje.*;
import static utilidades.UtilidadesItem.*;

public class Main {
    public static void main(String[] args) {
        Personaje garen = new Personaje();
        garen.setId(1);
        garen.setNombre("Garen");
        garen.setDescripcion("El poder de Demacia, un guerrero noble y valiente.");
        garen.setFechaCreacion(LocalDate.of(2010, 4, 27));
        garen.setNivel(1);
        garen.setVidaBase(620.0);
        garen.setVida(620.0);
        garen.setDefensaBase(36.0);
        garen.setDefensa(36.0);
        garen.setAtaqueBase(66.0);
        garen.setAtaque(66.0);
        garen.setManaBase(0.0);
        garen.setMana(0.0);
        garen.setRegion(Region.DEMACIA);

        Escalabilidad escalabilidadGaren = new Escalabilidad();
        escalabilidadGaren.setId(1);
        escalabilidadGaren.setIncrementoDanioNivel(4.5);
        escalabilidadGaren.setIncrementoDefensaNivel(3.0);
        escalabilidadGaren.setIncrementoSaludNivel(84.0);
        escalabilidadGaren.setIncrementoManaNivel(0.0);
        garen.setEscalabilidad(escalabilidadGaren);

        Habilidad juicio = new Habilidad();
        juicio.setId(1);
        juicio.setNombre("Juicio");
        juicio.setDanioBase(30.0);
        juicio.setDanio(30.0);
        juicio.setCosteMana(0.0);
        juicio.setTipoHabilidad(TipoHabilidad.DANIO);

        garen.setHabilidades(List.of(juicio));

        Item armaduraDeEspinas = new Item();
        armaduraDeEspinas.setId(1);
        armaduraDeEspinas.setNombre("Armadura de Espinas");
        armaduraDeEspinas.setAumentoDanio(0.0);
        armaduraDeEspinas.setAumentoDefensa(40.0);
        armaduraDeEspinas.setAumentoSalud(250.0);
        armaduraDeEspinas.setAumentoMana(0.0);

        garen.setEquipamiento(List.of(armaduraDeEspinas));

        Personaje ahri = new Personaje();
        ahri.setId(2);
        ahri.setNombre("Ahri");
        ahri.setDescripcion("Una vastaya con poderes mágicos y encantadores.");
        ahri.setFechaCreacion(LocalDate.of(2011, 12, 14));
        ahri.setNivel(1);
        ahri.setVidaBase(500.0);
        ahri.setVida(500.0);
        ahri.setDefensaBase(20.0);
        ahri.setDefensa(20.0);
        ahri.setAtaqueBase(53.0);
        ahri.setAtaque(53.0);
        ahri.setManaBase(334.0);
        ahri.setMana(334.0);
        ahri.setRegion(Region.JONIA);

        Escalabilidad escalabilidadAhri = new Escalabilidad();
        escalabilidadAhri.setId(2);
        escalabilidadAhri.setIncrementoDanioNivel(3.5);
        escalabilidadAhri.setIncrementoDefensaNivel(2.5);
        escalabilidadAhri.setIncrementoSaludNivel(80.0);
        escalabilidadAhri.setIncrementoManaNivel(50.0);
        ahri.setEscalabilidad(escalabilidadAhri);

        Habilidad orbeEngano = new Habilidad();
        orbeEngano.setId(2);
        orbeEngano.setNombre("Orbe del Engaño");
        orbeEngano.setDanioBase(40.0);
        orbeEngano.setDanio(40.0);
        orbeEngano.setCosteMana(55.0);
        orbeEngano.setTipoHabilidad(TipoHabilidad.DANIO);

        ahri.setHabilidades(List.of(orbeEngano));

        Item ecoDeLuden = new Item();
        ecoDeLuden.setId(2);
        ecoDeLuden.setNombre("Eco de Luden");
        ecoDeLuden.setAumentoDanio(80.0);
        ecoDeLuden.setAumentoDefensa(0.0);
        ecoDeLuden.setAumentoSalud(0.0);
        ecoDeLuden.setAumentoMana(600.0);

        ahri.setEquipamiento(new ArrayList<>());

        List<Personaje> personajes = new ArrayList<>();
        personajes.add(ahri);
        personajes.add(garen);

        System.out.println("Nivel de Ahri: " + ahri.getNivel());
        levelUp(ahri);
        System.out.println("Subir nivel Ahri: " + ahri.getNivel());
        maxearPersonaje(ahri);
        System.out.println("Maxear nivel de Ahri: " + ahri.getNivel());
        System.out.println("Mapa por region: " + getPersonajesPorRegion(personajes));
        System.out.println("El mas poderoso: " + getMasPoderoso(personajes));
        System.out.println("El mas poderoso por region: " + getMasPoderosoPorRegion(personajes));

        System.out.println("Items de Ahri: " + ahri.getEquipamiento());
        equiparItem(ahri, ecoDeLuden);
        System.out.println("Añadir un item a Ahri: " + ahri.getEquipamiento());


    }
}
