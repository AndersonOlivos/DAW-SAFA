package utilidades;

import modelos.Almacen;
import modelos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesAlmacen {

    /**
     * El método devuelve true si la suma de los productos que hay en un
     * almacén no supera la capacidad del almacén, teniendo en cuenta todos
     * los productos y todos los almacenes , cada uno con su correspondiente
     */

    public boolean validarAlmacenes(List<Producto> productos){
        Map<Almacen, List<Producto>> mapaAlmacenProductos = new HashMap<Almacen, List<Producto>>();

        for(Producto producto: productos){
            if(mapaAlmacenProductos.containsKey(producto.getAlmacen())){
                mapaAlmacenProductos.get(producto.getAlmacen()).add(producto);
            } else {
                mapaAlmacenProductos.put(producto.getAlmacen(), new ArrayList<>(List.of(producto)));
            }
        }

        for(Almacen almacen: mapaAlmacenProductos.keySet()){
            if(almacen.getCapacidad() < mapaAlmacenProductos.get(almacen).size()){
                return false;
            }
        }
        return true;
    }
}
