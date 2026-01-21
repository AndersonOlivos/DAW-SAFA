import {Component, OnDestroy, OnInit} from '@angular/core';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-fecha-hora',
  imports: [],
  templateUrl: './fecha-hora.html',
  styleUrl: './fecha-hora.css',
})
export class FechaHora implements OnInit , OnDestroy {
  fechaHora: string = formatDate(new Date(), 'dd-MM-yyyy HH:mm:ss', 'en-US');
  private intervaloId: any;

  ngOnInit() {
    this.actualizarFechaHora();
    this.intervaloId = setInterval(() => {
      this.actualizarFechaHora();
    }, 1000)
  }

  ngOnDestroy() {
    if(this.intervaloId){
      clearInterval(this.intervaloId);
    }
  }

  private actualizarFechaHora() {
    const ahora = formatDate(new Date(), 'dd-MM-yyyy HH:mm:ss', 'en-US');
    this.fechaHora = ahora;
  }
}
