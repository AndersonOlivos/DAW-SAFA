export class TarjetaProductoClass {
  private nombre: string;
  private descripcion: string;
  private precio: number;

  constructor(nombre: string, descripcion: string, precio: number) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
  }

  public getNombre() {
    return this.nombre;
  }
  public getDescripcion() {
    return this.descripcion;
  }
  public getPrecio() {
    return this.precio;
  }
}
