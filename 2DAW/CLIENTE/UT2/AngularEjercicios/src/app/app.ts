import {Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Ejercicio1} from '../ejercicio1/ejercicio1';
import {Tiempo} from '../tiempo/tiempo';
import {Ejercicio3} from '../ejercicio3/ejercicio3';
import {Ejercicio4} from '../ejercicio4/ejercicio4';
import {Ejercicio5} from '../ejercicio5/ejercicio5';
import {Ejercicio6} from '../ejercicio6/ejercicio6';
import {Ejercicio7} from '../ejercicio7/ejercicio7';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Ejercicio1, Tiempo, Ejercicio3, Ejercicio4, Ejercicio5, Ejercicio6, Ejercicio7],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  nombreEjercicio1 = 'Anderson';
}
