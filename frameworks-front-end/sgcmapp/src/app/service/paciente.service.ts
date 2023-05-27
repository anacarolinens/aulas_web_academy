import { Injectable } from '@angular/core';
import { IService } from './i-service';
import { Paciente } from '../model/paciente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService implements IService<Paciente> {
  

  constructor() { }

  apiUrl: string = "";

  get(termoBusca?: string | undefined): Observable<Paciente[]> {
    throw new Error('Method not implemented.');
  }

  getById(id: number): Observable<Paciente> {
    throw new Error('Method not implemented.');
  }
  
  insert(objeto: Paciente): Observable<Paciente> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Paciente): Observable<Paciente> {
    throw new Error('Method not implemented.');
  }
  
  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }
}
