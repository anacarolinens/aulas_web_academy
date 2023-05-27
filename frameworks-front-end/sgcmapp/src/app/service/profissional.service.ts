import { Injectable } from '@angular/core';
import { IService } from './i-service';
import { Profissional } from '../model/profissional';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfissionalService implements IService<Profissional> {

  constructor() { }

  apiUrl: string = "";

  get(termoBusca?: string | undefined): Observable<Profissional[]> {
    throw new Error('Method not implemented.');
  }

  getById(id: number): Observable<Profissional> {
    throw new Error('Method not implemented.');
  }

  insert(objeto: Profissional): Observable<Profissional> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Profissional): Observable<Profissional> {
    throw new Error('Method not implemented.');
  }
  
  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }
}
