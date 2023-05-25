import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AgendaListComponent } from './component/agenda-list/agenda-list.component';
import { AtendimentoListComponent } from './component/atendimento-list/atendimento-list.component';
import { AgendaFormComponent } from './component/agenda-form/agenda-form.component';

@NgModule({
  declarations: [
    AppComponent,
    AgendaListComponent,
    AtendimentoListComponent,
    AgendaFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
