import { Component, OnInit } from '@angular/core';
import { IForm } from '../i-form';
import { Atendimento } from 'src/app/model/atendimento';
import { NgForm } from '@angular/forms';
import { Profissional } from 'src/app/model/profissional';
import { Convenio } from 'src/app/model/convenio';
import { Paciente } from 'src/app/model/paciente';
import { AtendimentoService } from 'src/app/service/atendimento.service';
import { ConvenioService } from 'src/app/service/convenio.service';
import { PacienteService } from 'src/app/service/paciente.service';
import { ProfissionalService } from 'src/app/service/profissional.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-agenda-form',
  templateUrl: './agenda-form.component.html',
  styles: [
  ]
})
export class AgendaFormComponent implements IForm<Atendimento>, OnInit{

  constructor (
    private servico: AtendimentoService,
    private servicoConvenio: ConvenioService,
    private servicoPaciente: PacienteService,
    private servicoProfissional: ProfissionalService,
    private route: ActivatedRoute
    ){}
  ngOnInit(): void {
    
    this.servicoConvenio.get().subscribe({
      next: (resposta: Convenio[]) => {
        this.convenios = resposta;
      }
    });

    this.servicoPaciente.get().subscribe({
      next: (resposta: Paciente[]) => {
        this.pacientes = resposta;
      }
    });

    this.servicoProfissional.get().subscribe({
      next: (resposta: Profissional[]) => {
        this.profissionais = resposta;
      }
    });

    const id = this.route.snapshot.queryParamMap.get("id");
    if (id) {
      this.servico.getById(+id).subscribe({
        next: (resposta: Atendimento) => {
          this.registro = resposta;
        }
      });
    }

  }


  

  registro: Atendimento = <Atendimento>{};
  profissionais: Profissional[] = Array<Profissional>();
  convenios: Convenio[] = Array<Convenio>();
  pacientes: Paciente[] = Array<Paciente>();

  submit(form: NgForm): void {

    this.servico.insert(this.registro).subscribe({
      //garantindo que o metodo seja chamado
      complete: () => {
        form.resetForm();
      }
    });

  }

}
