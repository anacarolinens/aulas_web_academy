import { Component } from '@angular/core';
import { IForm } from '../i-form';
import { Atendimento } from 'src/app/model/atendimento';
import { NgForm } from '@angular/forms';
import { Profissional } from 'src/app/model/profissional';
import { Convenio } from 'src/app/model/convenio';
import { Paciente } from 'src/app/model/paciente';

@Component({
  selector: 'app-agenda-form',
  templateUrl: './agenda-form.component.html',
  styles: [
  ]
})
export class AgendaFormComponent implements IForm<Atendimento> {

  registro: Atendimento = <Atendimento>{};
  profissionais: Profissional[] = Array<Profissional>();
  convenios: Convenio[] = Array<Convenio>();
  pacientes: Paciente[] = Array<Paciente>();

  submit(form: NgForm): void {};

}
