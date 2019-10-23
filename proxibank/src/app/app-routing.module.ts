import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthentificationComponent } from './authentification/authentification.component';
import { ListConseillerComponent } from './conseillers/list-conseiller/list-conseiller.component';
import { CreateConseillerComponent } from './conseillers/create-conseiller/create-conseiller.component';
import { ListClientComponent } from './clients/list-client/list-client.component';
import { EditConseillerComponent } from './conseillers/edit-conseiller/edit-conseiller.component';
import { EditClientComponent } from './clients/edit-client/edit-client.component';
import { CreateClientComponent } from './clients/create-client/create-client.component';
import { VirementComponent } from './virement/virement.component';
import { ParametrageComponent } from './parametrage/parametrage.component';
import { AffectationClientConseillerComponent } from './client-conseiller/affectation-client-conseiller.component';
import { ListComptesComponent } from './list-comptes/list-comptes.component';
import {MesClientsComponent} from "./mes-clients/mes-clients.component";
import {AccueilComponent} from "./accueil/accueil.component";
import {LoginGuard} from "./services/login.guard";
import {AuthGuard} from "./services/auth.guard";


const routes: Routes = [
  {path: '', redirectTo: 'accueil', pathMatch: 'full' },
  {path: 'accueil', component: AccueilComponent },
  {path: 'authentification', canActivate: [LoginGuard], component: AuthentificationComponent },
  {path: '', canActivate: [AuthGuard], children: [
  {path: 'mesclients', component: MesClientsComponent },
  {path: 'list_conseiller', component: ListConseillerComponent },
  {path: 'create_conseiller', component: CreateConseillerComponent },
  {path: 'list_client', component: ListClientComponent },
  {path: 'edit_conseiller/:id', component: EditConseillerComponent },
  {path: 'edit_client/:id', component: EditClientComponent },
  {path: 'create_client', component: CreateClientComponent },
  {path: 'virement', component: VirementComponent },
  {path: 'parametrage', component: ParametrageComponent },
  {path: 'list_comptes/:id', component: ListComptesComponent },
  {path: 'affectation_client_conseiller/:id', component: AffectationClientConseillerComponent }]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
