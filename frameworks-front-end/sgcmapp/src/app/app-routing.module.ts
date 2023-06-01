import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgendaListComponent } from './component/agenda-list/agenda-list.component';
import { AgendaFormComponent } from './component/agenda-form/agenda-form.component';
import { AtendimentoListComponent } from './component/atendimento-list/atendimento-list.component';
import { LoginComponent } from './component/login/login.component';
import { UsuarioComponent } from './component/usuario/usuario.component';
import { AutenticacaoGuard } from './service/autenticacao.guard';

//criando rotas de cada componente
const routes: Routes = [
  { path: '', canActivate: [AutenticacaoGuard], children: [

    { path: 'agenda', component: AgendaListComponent},
    { path: 'agenda/form', component: AgendaFormComponent},
    { path: 'atendimento', component: AtendimentoListComponent},
    { path: 'config', canActivate: [AutenticacaoGuard], data: { papel: 'ROLE_ADMIN'}, children: [
      { path: 'usuarios', component: UsuarioComponent},
    ]}
    ]},

  { path: 'login', component: LoginComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
