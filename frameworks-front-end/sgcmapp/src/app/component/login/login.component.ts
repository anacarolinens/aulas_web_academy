import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Usuario } from 'src/app/model/usuario';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent {

  //injeção de dependencias
  constructor (
    private servico: LoginService

  ) {}

   //mapeando o usuário para verificar o login
  usuario: Usuario = <Usuario>{};

  submit(form: NgForm): void {
    this.servico.login(this.usuario);
    form.resetForm();
  }

 


}
