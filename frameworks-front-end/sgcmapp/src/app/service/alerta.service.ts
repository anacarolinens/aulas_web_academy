import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Alerta } from '../model/alerta';

@Injectable({
  providedIn: 'root'
})
export class AlertaService {

  private controleAlerta: Subject<Alerta>;

  constructor() { 
    this.controleAlerta = new Subject<Alerta>();
  }

  enviarAlerta(alerta: Alerta): void {
    this.controleAlerta.next(alerta); //objeto do tipo object, que é um Observable que consegue enviar e info e quem recebe recebe a info
  }
  receberAlerta(): Observable<Alerta> {
    return this.controleAlerta.asObservable(); //mandando o objeito completo, quem chamou o metodo consegue capturar a info
  }

}
