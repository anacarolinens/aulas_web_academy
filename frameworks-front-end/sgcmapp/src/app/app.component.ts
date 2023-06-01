import { Component } from '@angular/core';
import { LoginService } from './service/login.service';
import { Usuario } from './model/usuario';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SGCM';
  
  constructor(
    private servicoLogin: LoginService

  ){}

  //metodos paa controlar a interface do usuário

    isAutenticado(): boolean {
      return this.servicoLogin.isAutenticado();
      
    }

    isAdmin(): boolean {
      return this.servicoLogin.isAdmin();
  
    }

    getUsuario(): Usuario {
      return this.servicoLogin.getUsuario();
    
    }

    //Invocando o logout
    logout(): void {
      this.servicoLogin.logout();
    }

}
