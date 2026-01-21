import {Component, OnInit} from '@angular/core';
import {FormsModule} from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-cookie',
  imports: [
    FormsModule
  ],
  templateUrl: './cookie.html',
  styleUrl: './cookie.css',
})
export class Cookie implements OnInit {
  nombre: string = "";

  constructor(private cookieService: CookieService) {
  }

  ngOnInit() {
    if(this.cookieService.get('username') != null){
      this.nombre = this.cookieService.get('username');
    }
  }

  actualizarUsername(){
    this.cookieService.set('username', this.nombre);
  }
}
