import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../model/usuario';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  //injeções de dependencias
  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  private autenticado: boolean = false;
  private usuario: Usuario = <Usuario>{}; //objeto vazio

  //verificando se o usuário está autenticado
  isAutenticado(): boolean {
    return this.autenticado;
  }

  //verificando se o usuario autenticado é admin
  isAdmin(): boolean {
    return this.usuario.papel == "ROLE_ADMIN";
  }

  //retortar objeto usuário
  getUsuario(): Usuario {
    return this.usuario;
  }

  //recebe o parametro de login
  login(usuario: Usuario): void {
    //recebe o usuário
    this.usuario = usuario;
    //concatenando usuario e senha
    const credenciaisCodificadas = btoa(usuario.nomeUsuario + ':' + usuario.senha);
    //Alterar o cabeçalho da requisição http
    const opcoesHttp = {

      headers: new HttpHeaders({
        'Authorization' : 'Basic ' + credenciaisCodificadas
      })
    };
    //ir na requisição no back-end fazer o login do usuario
    const url = environment.API_URL + '/user_info';
    this.http.get<Usuario>(url, opcoesHttp).subscribe({
      //capturando o usuário
      next: (usuario: Usuario) => {
        if (usuario) {
          this.autenticado = true;
          //dizendo qual é o usuário
          this.usuario = usuario;
          //transformando o objeto usuário em json e gravando
          sessionStorage.setItem('usuario',JSON.stringify(usuario) );

          //redirecionanod o usuario para a raiz da aplicação
          this.router.navigate(['/']);
        }
      }
    })


  }

  logout(): void {
    const url = environment.API_URL + '/logout';
    //fazendo a requisição
    this.http.get(url).subscribe({
      //aerofunction para desfazer o login
      complete: () => {
        this.autenticado = false;
        //usuario volta a ser um objeto vazio
        this.usuario = <Usuario> {};
        sessionStorage.removeItem('usuario');
        //redirecionando para o formulário de login
        this.router.navigate(['/login']);
      }
    })
  }

  //fazendo a verificação/ validação do login
  verificaLogin(): boolean {

    //verifica quando o objeto usuario não está autenticado e o redireciona para o login
    if(!this.isAutenticado()){
      this.usuario = JSON.parse ( //metodo json pega a string e torna um objeto
        sessionStorage.getItem('usuario') || '{}'
      );
      //verificando se o objeto tem propriedades ou não do objeto usuario
      if(Object.keys(this.usuario).length > 0){
        //validando a sessão do usuario
        this.autenticado = true;
      } else {
        this.router.navigate(['/login']);
      }
  
    }

    return this.isAutenticado();
  }

}
