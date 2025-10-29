import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-ejercicio7',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './ejercicio7.html',
  styleUrl: './ejercicio7.css',
})
export class Ejercicio7 {
  num1!: number;
  num2!: number;
  private res : HTMLElement = <HTMLElement>document.getElementById("resultado");

  constructor() {
    console.log(this.res)
  }

  operar(o:string):void {
    switch (o) {
      case 'sumar':
        this.res.innerHTML = (this.num1 + this.num2).toString();
        break;
      case 'restar':
        this.res.innerHTML = (this.num1 - this.num2).toString();
        break;
      case 'multiplicar':
        this.res.innerHTML = (this.num1 * this.num2).toString();
        break;
      case 'dividir':
        if(this.num2 == 0){
          this.res.innerHTML = "Imposible calcular";
        } else{
          this.res.innerHTML = (this.num1 / this.num2).toString();
        }
        break;
      default:
        this.res.innerHTML = "";
        break;
    }
  }
}
