import {Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Ejercicio1} from '../ejercicio1/ejercicio1';
import {Tiempo} from '../tiempo/tiempo';
import {Ejercicio3} from '../ejercicio3/ejercicio3';
import {Ejercicio4} from '../ejercicio4/ejercicio4';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Ejercicio1, Tiempo, Ejercicio3, Ejercicio4],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  nombreEjercicio1 = 'Anderson';
}
