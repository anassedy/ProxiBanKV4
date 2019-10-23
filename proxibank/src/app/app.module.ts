import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { ListConseillerComponent } from './conseillers/list-conseiller/list-conseiller.component';
import { CreateConseillerComponent } from './conseillers/create-conseiller/create-conseiller.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { EditConseillerComponent } from './conseillers/edit-conseiller/edit-conseiller.component';
import { ListClientComponent } from './clients/list-client/list-client.component';
import { CreateClientComponent } from './clients/create-client/create-client.component';
import { EditClientComponent } from './clients/edit-client/edit-client.component';
import { VirementComponent } from './virement/virement.component';
import { ListComptesComponent } from './list-comptes/list-comptes.component';
import { AffectationClientConseillerComponent } from './client-conseiller/affectation-client-conseiller.component';
import { ParametrageComponent } from './parametrage/parametrage.component';
import { MesClientsComponent } from './mes-clients/mes-clients.component';
import {TokenInterceptorService} from "./services/token-interceptor.service";
import { AccueilComponent } from './accueil/accueil.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthentificationComponent,
    ListConseillerComponent,
    CreateConseillerComponent,
    HeaderComponent,
    EditConseillerComponent,
    ListClientComponent,
    CreateClientComponent,
    EditClientComponent,
    VirementComponent,
    ListComptesComponent,
    AffectationClientConseillerComponent,
    ParametrageComponent,
    MesClientsComponent,
    AccueilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent],
})
export class AppModule { }
