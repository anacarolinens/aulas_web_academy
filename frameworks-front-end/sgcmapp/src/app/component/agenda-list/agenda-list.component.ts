import { Component } from '@angular/core';
import { IList } from '../i-list';
import { Atendimento } from 'src/app/model/atendimento';

@Component({
  selector: 'app-agenda-list',
  templateUrl: './agenda-list.component.html',
  styles: [
  ]
})

export class AgendaListComponent implements IList<Atendimento> {

  registros: Atendimento[] = Array<Atendimento>();

  get(termoBusca?: string | undefined): void {
    console.log(termoBusca);
  }

  delete(id: number): void {
    throw new Error('Method not implemented.');
  }
  

}
