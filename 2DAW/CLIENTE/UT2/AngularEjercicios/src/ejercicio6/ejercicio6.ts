import { Component } from '@angular/core';
import {TarjetaProductoClass} from '../tarjeta-producto-class';
import {TarjetaProducto} from '../tarjeta-producto/tarjeta-producto';

@Component({
  selector: 'app-ejercicio6',
  imports: [
    TarjetaProducto
  ],
  templateUrl: './ejercicio6.html',
  styleUrl: './ejercicio6.css',
})
export class Ejercicio6 {

  prueba1: TarjetaProductoClass = new TarjetaProductoClass("Tostada de aguacate", "Aguacate natural y sano.", 20.90);
  listaProductos: Array<TarjetaProductoClass> = [this.prueba1];

}
