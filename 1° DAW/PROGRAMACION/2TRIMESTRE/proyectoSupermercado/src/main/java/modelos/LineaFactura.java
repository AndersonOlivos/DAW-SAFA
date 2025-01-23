package modelos;

import java.util.Objects;

public class LineaFactura {

    private Integer idLineaFactura;
    private Factura factura;
    private Producto producto;
    private Integer cantidad;

    public LineaFactura() {
    }

    public LineaFactura(Integer idLineaFactura, Factura factura, Producto producto, Integer cantidad) {
        this.idLineaFactura = idLineaFactura;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Integer getIdLineaFactura() {
        return idLineaFactura;
    }

    public void setIdLineaFactura(Integer idLineaFactura) {
        this.idLineaFactura = idLineaFactura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaFactura{" +
                "idLineaFactura=" + idLineaFactura +
                ", factura=" + factura +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LineaFactura that = (LineaFactura) o;
        return Objects.equals(idLineaFactura, that.idLineaFactura) && Objects.equals(factura, that.factura) && Objects.equals(producto, that.producto) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLineaFactura, factura, producto, cantidad);
    }
}
