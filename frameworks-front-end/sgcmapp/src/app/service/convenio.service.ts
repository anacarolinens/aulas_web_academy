import { Injectable } from '@angular/core';
import { IService } from './i-service';
import { Convenio } from '../model/convenio';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConvenioService implements IService<Convenio> {

  constructor() { }

  apiUrl: string = "";

  get(termoBusca?: string | undefined): Observable<Convenio[]> {
    throw new Error('Method not implemented.');
  }

  getById(id: number): Observable<Convenio> {
    throw new Error('Method not implemented.');
  }

  insert(objeto: Convenio): Observable<Convenio> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Convenio): Observable<Convenio> {
    throw new Error('Method not implemented.');
  }
  
  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }
}
