import { Component } from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'app-navegacion-historial',
  imports: [],
  templateUrl: './navegacion-historial.html',
  styleUrl: './navegacion-historial.css',
})
export class NavegacionHistorial {
  constructor(private location: Location) { }

  goAtras():void {
    this.location.back();
  }

  goAdelante():void {
    this.location.forward();
  }

  goRefrescar():void {
    window.location.reload();
  }

}
