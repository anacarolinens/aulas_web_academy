import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class RequisicaoInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    //modificando o request em um clone e adicionando propriedades
    request = request.clone({
      //requisição que vai ser criada com a assinatura do usuario
      withCredentials: true,
      headers: request.headers.set('X-Requested-With', 'XMLHttpResqueste') //dizendo que a requisição tem um cliente
    });

    return next.handle(request);
  }
}
