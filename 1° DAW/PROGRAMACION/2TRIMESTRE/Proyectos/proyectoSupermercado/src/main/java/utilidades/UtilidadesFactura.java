package utilidades;
import modelos.Cliente;
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

    /**
     * Que devuelve la suma del importe total de las facturas , que pertenecen
     * al cliente pasado como parámetro
     */

    public Double gastoTotalCliente(List<Factura> facturas, Cliente cliente){
        Double totalCliente = 0.0;
        for (Factura factura : facturas){
            if(factura.getCliente().equals(cliente)){
                totalCliente += calcularTotalAPagar(factura);
            }
        }
        return totalCliente;
    }

    /**
     * Que devuelve la suma del importe total de las facturas , que pertenecen
     * al cliente pasado como parámetro
     */

    public Double totalFacturadoPeriodo(List<Factura> facturas, LocalDate fechaInicio, LocalDate fechaFin){
        Double totalFacturadoPeriodo = 0.0;
        for (Factura factura : facturas){
            if(fechaInicio.compareTo(factura.getFechaVencimiento()) <= 0 && fechaFin.compareTo(factura.getFechaVencimiento()) >= 0){
                totalFacturadoPeriodo += calcularTotalAPagar(factura);
            }
        }
        return totalFacturadoPeriodo;
    }

}
