import { Component } from '@angular/core';
import {Tarea} from "../tarea/tarea";
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-ejercicio3',
  imports: [
    Tarea,
    FormsModule
  ],
  templateUrl: './ejercicio3.html',
  styleUrl: './ejercicio3.css',
})
export class Ejercicio3 {
  tareas:Array<String> = ['Comprar pan'];

  inpTarea: String = '';

  anadir_tarea(){
    if(this.inpTarea.length!=0){
      this.tareas.push(this.inpTarea);
    }
  }
}
