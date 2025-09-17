/**
 * Clase del juego
 * @authord Anderson
 * @version 1.0
 */
package Ejercicio2Ref;

public class Game {

    Player p;

    /**
     * Metodo para mover el jugador de posicion
     * @param m Direccion del movimiento
     */

    public void movement(String m){
        if (m.equalsIgnoreCase("Derecha")){
            p.moverDerecha();
        }
        if (m.equalsIgnoreCase("Izquierda")){
            p.moverIzquierda();
        }
        if (m.equalsIgnoreCase("Abajo")){
            p.moverAbajo();
        }
        if (m.equalsIgnoreCase("Arriba")){
            p.moverArriba();
        }
    }

}
