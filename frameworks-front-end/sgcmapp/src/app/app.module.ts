import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AgendaListComponent } from './component/agenda-list/agenda-list.component';
import { AgendaFormComponent } from './component/agenda-form/agenda-form.component';
import { AtendimentoListComponent } from './component/atendimento-list/atendimento-list.component';
import { FormsModule } from '@angular/forms';
import { BarraComandosComponent } from './component/barra-comandos/barra-comandos.component';
import { AlertaComponent } from './component/alerta/alerta.component';
import { ErroInterceptor } from './interceptor/erro.interceptor';
import { LoginComponent } from './component/login/login.component';
import { RequisicaoInterceptor } from './interceptor/requisicao.interceptor';
import { UsuarioComponent } from './component/usuario/usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    AgendaListComponent,
    AgendaFormComponent,
    BarraComandosComponent, 
    AtendimentoListComponent, AlertaComponent, LoginComponent, UsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: ErroInterceptor, multi: true
    },
    {
      provide: HTTP_INTERCEPTORS, useClass: RequisicaoInterceptor, multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
