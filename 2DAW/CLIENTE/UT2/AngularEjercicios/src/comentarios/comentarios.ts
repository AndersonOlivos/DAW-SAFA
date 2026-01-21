import {Component, EventEmitter, Output} from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-comentarios',
  imports: [
    FormsModule,
  ],
  templateUrl: './comentarios.html',
  styleUrl: './comentarios.css',
})
export class Comentarios {
  nuevoComentario: string = '';
  comentarios: string[] = [];

  @Output() comentarioEnviado = new EventEmitter<string>();

  enviarComentario() {
    if (this.nuevoComentario.trim() !== '') {
      this.comentarios.push(this.nuevoComentario);
      this.comentarioEnviado.emit(this.nuevoComentario);
      this.nuevoComentario = '';
    }
  }
}
