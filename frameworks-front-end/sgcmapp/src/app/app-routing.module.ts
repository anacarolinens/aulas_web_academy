import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgendaListComponent } from './component/agenda-list/agenda-list.component';
import { AgendaFormComponent } from './component/agenda-form/agenda-form.component';
import { AtendimentoListComponent } from './component/atendimento-list/atendimento-list.component';
import { LoginComponent } from './component/login/login.component';

//criando rotas de cada componente
const routes: Routes = [
  { path: 'agenda', component: AgendaListComponent},
  { path: 'agenda/form', component: AgendaFormComponent},
  { path: 'atendimento', component: AtendimentoListComponent},
  { path: 'login', component: LoginComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
