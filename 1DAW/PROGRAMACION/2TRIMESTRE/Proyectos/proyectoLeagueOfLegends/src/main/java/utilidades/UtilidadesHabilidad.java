package utilidades;

import modelos.Habilidad;
import modelos.Item;
import modelos.Personaje;
import modelos.TipoHabilidad;

import static utilidades.UtilidadesItem.*;
import static utilidades.UtilidadesPersonaje.*;

public class UtilidadesHabilidad {

    public static void golpearConHabilidad(Personaje emisor, Personaje receptor, Habilidad habilidadEmisor){

        if(habilidadEmisor.getTipoHabilidad().equals(TipoHabilidad.DANIO)){

            //MAXEAMOS EL NIVEL 18 LOS DOS PERSONAJES

            maxearPersonaje(emisor);
            maxearPersonaje(receptor);

            //ACTUALIZAMOS LOS STATS DE LOS CAMPEONES

            for(Item item : emisor.getEquipamiento()){
                equiparItem(emisor, item);
            }
            for(Item item : receptor.getEquipamiento()){
                equiparItem(receptor, item);
            }

            //CALCULAR POTENCIA HABILIDAD LANZADA

            Double danioHabilidadTotal = emisor.getAtaqueBase() + (0.2 * emisor.getAtaque()) - (0.1 * receptor.getDefensa());

            //QUITAMOS EL COSTE DE MANA AL EMISOR

            emisor.setMana(emisor.getMana() - habilidadEmisor.getCosteMana());

            //QUITAMOS VIDA DEL RECEPTOR

            receptor.setVida(receptor.getVida() - danioHabilidadTotal);

        }
    }

}
