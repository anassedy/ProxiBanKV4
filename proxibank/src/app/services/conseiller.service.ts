import { Injectable } from '@angular/core';
import { Conseiller } from '../models/conseiller.models';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Client } from '../models/client.models';

@Injectable({
  providedIn: 'root'
})
export class ConseillerService {
/* le gérant va pouvoir afficher la liste des conseillers, modifier, supprimer les infos conseiller ou afficher un conseiller par son Id */
  constructor(private httpClient: HttpClient) { }
  getAll() : Observable<Conseiller[]>{
    return this.httpClient.get<Conseiller[]>(environment.serverUrl + "conseillers");
   }
   getById(id: number) {
    return this.httpClient.get<Conseiller>(environment.serverUrl + "conseiller/" + id)
  }
  create(conseiller: Conseiller) {
    return this.httpClient.post<Conseiller>(environment.serverUrl + "conseiller", conseiller);
  }
  update(conseiller: Conseiller) {
    return this.httpClient.put<Conseiller>(environment.serverUrl + "conseiller/" + conseiller.id, conseiller)
  }
  delete(id: number) {
    return this.httpClient.delete<Conseiller>(environment.serverUrl + "conseiller/" + id)
  }


  loadClientsParConseiller(id: number): Observable<Client[]> {
    return this.httpClient.get<Client[]>(environment.serverUrl + 'clients/' + id + "/all")
      .map((clients: any[]) => clients.map(data => new Client()));
}
}
