package Ejercicio2Ref;

/**
 * Clase del jugador
 * @author Anderson
 * @version 1.0
 */

public class Player {

    int x, y;

    /**
     * Constructor vacío
     */
    public Player() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor con posiciones iniciales pasadas por parametro
     * @param x Posicion x del jugador
     * @param y Posicion y del jugador
     */
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metodo para obtener el valor de la posicion X del jugador
     * @return
     */

    public int getX() {
        return x;
    }

    /**
     * Metodo para setear la posicion X del jugador
     * @param x
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metodo para obtener el valor de la posicion Y del jugador
     * @return
     */

    public int getY() {
        return y;
    }

    /**
     * Metodo para setear la posicion Y del jugador
     * @param y
     */

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Metodo para mover el jugador a la derecha
     */

    public void moverDerecha(){
        x = x + 1;
    }

    /**
     * Metodo para mover el jugador a la izquierda
     */

    public void moverIzquierda(){
        x = x - 1;
    }

    /**
     * Metodo para mover el jugador para abajo
     */

    public void moverAbajo(){
        y = y + 1;
    }

    /**
     * Metodo para mover el jugador para arriba
     */

    public void moverArriba(){
        y = y - 1;
    }
}
