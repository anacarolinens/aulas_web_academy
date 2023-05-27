import { Component, OnInit } from '@angular/core';
import { IList } from '../i-list';
import { Atendimento } from 'src/app/model/atendimento';
import { AtendimentoService } from 'src/app/service/atendimento.service';

@Component({
  selector: 'app-agenda-list',
  templateUrl: './agenda-list.component.html',
  styles: [
  ]
})

//Todo objeto no angular tem um tempo de vida

export class AgendaListComponent implements IList<Atendimento>, OnInit{

  constructor(private servico: AtendimentoService) {

  }
  ngOnInit(): void {
    this.get();
  }

  registros: Atendimento[] = Array<Atendimento>();
  status: string[] = ['AGENDADO', 'CONFIRMADO'];

  get(termoBusca?: string | undefined): void {
   this.servico.get(termoBusca).subscribe({
    next: (resposta: Atendimento []) => {
    this.registros = resposta.filter(item => {
      return this.status.includes(item.status);
    });
    }
   });
   
  }

  delete(id: number): void {
    throw new Error('Method not implemented.');
  }
  

}
