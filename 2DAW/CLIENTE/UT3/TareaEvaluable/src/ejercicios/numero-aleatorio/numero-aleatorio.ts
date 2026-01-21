import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-numero-aleatorio',
  imports: [
    FormsModule
  ],
  templateUrl: './numero-aleatorio.html',
  styleUrl: './numero-aleatorio.css',
})
export class NumeroAleatorio {

  numeros: number[] = [];
  cantidad: number = 1;

  generarNumeros(): void {
    this.numeros = [];
    for (let i = 0; i < this.cantidad; i++) {
      this.numeros.push(this.generarNumeroAleatorio());
    }
  }

  private generarNumeroAleatorio(): number {
    return Math.floor(Math.random() * 100) + 1;
  }
}
