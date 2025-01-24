package utilidades;
import modelos.Factura;
import modelos.LineaFactura;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesFactura {

    public boolean esFacturaVencida(Factura factura){
        return LocalDate.now().isBefore(factura.getFechaVencimiento());
    }

    public double calcularBaseFactura(Factura factura) {
        double importeBase = 0.0;
        for (LineaFactura linea : factura.getLineaFacturas()){
            importeBase += (linea.getCantidad()*linea.getProducto().getPrecio());
        }
        return importeBase;
    }

    public double calcularTotalAPagar(Factura factura){
        double importeBase = calcularBaseFactura(factura);
        double totalAPagar = (importeBase - factura.getDescuento())*factura.getIva();
        return totalAPagar;
    }
}
