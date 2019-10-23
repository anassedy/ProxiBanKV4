import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { Compte, CompteCourant, CompteEpargne } from '../models/compte.models';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  constructor(private httpClient : HttpClient) { }
  /**
  * Affiche un compte par son numéro.
  */
getCompteByNumCompte(numCompte: number):Observable<any> {
  return this.httpClient.get(environment.serverUrl + "comptes/"+ numCompte)
}
getAllCompte() : Observable<Compte[]>{
  return this.httpClient.get<Compte[]>(environment.serverUrl + "comptes");
 }
  /**
  * Supprime le compte courant sélectionné.
  */
 supprimerCompte(numCompte: number) {
  return this.httpClient.delete(environment.serverUrl + "compte/"+ numCompte);
}

/**
* Supprime le compte épargne sélectionné.
*/
deleteCompteEpargne(id: number) {
  return this.httpClient.delete(`${environment.serverUrl}clients/${id}/comptesEpargne`);
}
/**
  * Ajoute un compte courant.
  */
 AjouterCompteCourant(id: number, compteCourant: CompteCourant): Observable<any> {
  const url = `${environment.serverUrl}clients/${id}/ComptesCourant` + (compteCourant.numCompte ? `/${compteCourant.numCompte}` : '');
  const method = compteCourant.numCompte ? 'put' : 'post';
  return this.httpClient.request(method, url, { body: compteCourant });
}

/**
* Ajoute un compte courant.
*/
AjouterCompteEpargne(id: number, compteEpargne: CompteEpargne): Observable<any> {
  const url = `${environment.serverUrl}clients/${id}/ComptesEpargne` + (compteEpargne.numCompte ? `/${compteEpargne.numCompte}` : '');
  const method = compteEpargne.numCompte ? 'put' : 'post';
  return this.httpClient.request(method, url, { body: compteEpargne });
}
}
