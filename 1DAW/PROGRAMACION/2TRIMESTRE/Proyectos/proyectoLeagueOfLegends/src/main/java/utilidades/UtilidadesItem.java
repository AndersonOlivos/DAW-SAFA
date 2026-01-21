package utilidades;

import modelos.Item;
import modelos.Personaje;

public class UtilidadesItem {

    public static void equiparItem(Personaje personaje, Item item) {
        personaje.getEquipamiento().add(item);
        Double vidaActualizada = personaje.getVida() + item.getAumentoSalud();
        Double manaActualizada = personaje.getMana() + item.getAumentoMana();
        Double ataqueActualizada = personaje.getAtaque() + item.getAumentoDanio();
        Double defensaActualizada = personaje.getDefensa() + item.getAumentoDefensa();
        personaje.setVida(vidaActualizada);
        personaje.setMana(manaActualizada);
        personaje.setAtaque(ataqueActualizada);
        personaje.setDefensa(defensaActualizada);
    }
}
