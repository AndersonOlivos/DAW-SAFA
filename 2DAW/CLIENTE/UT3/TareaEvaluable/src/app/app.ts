import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FechaHora} from '../ejercicios/fecha-hora/fecha-hora';
import {NumeroAleatorio} from '../ejercicios/numero-aleatorio/numero-aleatorio';
import {NavegacionHistorial} from '../ejercicios/navegacion-historial/navegacion-historial';
import {VentanaHija} from '../ejercicios/ventana-hija/ventana-hija';
import {Cookie} from '../ejercicios/cookie/cookie';

@Component({
  selector: 'app-root',
  imports: [FechaHora, NumeroAleatorio, NavegacionHistorial, VentanaHija, Cookie],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('TareaEvaluable');
}
