import {Component, Input} from '@angular/core';
import {TarjetaProductoClass} from '../tarjeta-producto-class';

@Component({
  selector: 'app-tarjeta-producto',
  imports: [],
  templateUrl: './tarjeta-producto.html',
  styleUrl: './tarjeta-producto.css',
})
export class TarjetaProducto {
  @Input() tarjetaProducto!: TarjetaProductoClass;
}
