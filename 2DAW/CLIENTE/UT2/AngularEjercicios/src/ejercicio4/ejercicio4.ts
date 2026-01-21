import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {interval, Subscription} from 'rxjs';

@Component({
  selector: 'app-ejercicio4',
  imports: [
    FormsModule
  ],
  templateUrl: './ejercicio4.html',
  styleUrl: './ejercicio4.css',
})
export class Ejercicio4 {

  inpValor:number = 10;
  private sub!: Subscription;

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  empezar(){
    this.sub = interval(1000).subscribe(()=>{
      if(this.inpValor==0){
        this.pausar()
      }else {
        this.inpValor--;
      }
    })
  }

  pausar(){
    this.ngOnDestroy()
  }

  reiniciar(){
    this.inpValor = 0;
  }
}
