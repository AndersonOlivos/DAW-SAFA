import { Component } from '@angular/core';

@Component({
  selector: 'app-ventana-hija',
  imports: [],
  templateUrl: './ventana-hija.html',
  styleUrl: './ventana-hija.css',
})
export class VentanaHija {
  ventana: Window | null = null;

  abrirVentana(){
    this.ventana = window.open('', '_blank', 'width=600, height=600, left=200, top=200');
  }

  moverAbajo(){
    if(this.ventana){
      this.ventana.moveBy(0,100);
    }
  }

  moverArriba(){
    if(this.ventana){
      this.ventana.moveBy(0,-100);
    }
  }

  moverIzquierda(){
    if(this.ventana){
      this.ventana.moveBy(-100,0);
    }
  }

  moverDerecha(){
    if(this.ventana){
      this.ventana.moveBy(100,0);
    }
  }

  cerrarVentana(){
    if(this.ventana){
      this.ventana.close();
      this.ventana=null;
    }
  }
}
