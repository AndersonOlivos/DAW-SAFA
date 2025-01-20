import modelos.Almacen;
import modelos.Producto;
import modelos.TipoProducto;
import java.time.LocalDate;

public class pruebaV1 {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(3,"Amazon SA", 300);
        System.out.println(almacen);

        Producto producto = new Producto(4,"CASA121", "Descripcion", LocalDate.of(2025, 12, 31) , TipoProducto.BEBIDA, almacen);
        System.out.println(producto);
    }
}
