import {Component, EventEmitter, Output} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-comentarios',
  imports: [
    FormsModule,
    NgForOf
  ],
  templateUrl: './comentarios.html',
  styleUrl: './comentarios.css',
})
export class Comentarios {
  nuevoComentario: string = '';
  comentarios: string[] = [];

  // Usamos @Output() para notificar al componente padre
  @Output() comentarioEnviado = new EventEmitter<string>();

  enviarComentario() {
    if (this.nuevoComentario.trim() !== '') {
      this.comentarios.push(this.nuevoComentario);
      this.comentarioEnviado.emit(this.nuevoComentario); // notifica al padre
      this.nuevoComentario = '';
    }
  }
}
