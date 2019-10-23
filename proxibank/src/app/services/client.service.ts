import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../models/client.models';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
/* le conseiller va pouvoir afficher la liste des clients, modifier, supprimer les infos client ou afficher un client par son code */
  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(environment.serverUrl + "clients");
   }
   getById(id: number) {
    return this.httpClient.get<Client>(environment.serverUrl + "client/" + id)
  }
  create(client: Client, id: number) {
    return this.httpClient.post<Client>(environment.serverUrl + "client/" + id, client);
  }
  update(client: Client) {
    return this.httpClient.put<Client>(environment.serverUrl + "client/" + client.id, client)
  }
  delete(id: number) {
    return this.httpClient.delete<Client>(environment.serverUrl + "client/" + id)
  }
  getClientsByConseiller(id: number) {
    return this.httpClient.get('http://localhost:8080/clientbycc/' + id);
  }

  affecterConseiller(id, idClient) {
    const client = {id: idClient};
    return this.httpClient.put(`http://localhost:8080/affecterclient/${idClient}/${id}`, {"id": "8"});
  }
}
