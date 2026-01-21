import { Component } from '@angular/core';
import {Comentarios} from '../comentarios/comentarios';

@Component({
  selector: 'app-ejercicio5',
  imports: [
    Comentarios
  ],
  templateUrl: './ejercicio5.html',
  styleUrl: './ejercicio5.css',
})
export class Ejercicio5 {
  comentariosRecibidos: string[] = [];

  onComentarioEnviado(comentario: string) {
    this.comentariosRecibidos.push(comentario);
    console.log('Nuevo comentario recibido:', comentario);
  }
}
