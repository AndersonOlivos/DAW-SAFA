import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-tarea',
  imports: [],
  templateUrl: './tarea.html',
  styleUrl: './tarea.css',
})
export class Tarea {
  @Input() nombreTarea!: String;
}
