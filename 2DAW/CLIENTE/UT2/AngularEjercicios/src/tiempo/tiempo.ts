import {Component, OnDestroy, OnInit} from '@angular/core';
import {interval, Subscription} from 'rxjs';

@Component({
  selector: 'app-tiempo',
  imports: [],
  templateUrl: './tiempo.html',
  styleUrl: './tiempo.css',
})
export class Tiempo{
  hora:String = '';
  private sub !: Subscription;

  ngOnInit() {
    this.sub = interval(100).subscribe(()=>{
      this.hora = new Date().toLocaleTimeString('es-ES');
    })
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
