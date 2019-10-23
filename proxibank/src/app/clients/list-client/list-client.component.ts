import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.models';
import { ClientService } from 'src/app/services/client.service';
import { ConseillerService } from 'src/app/services/conseiller.service';
import { Conseiller } from 'src/app/models/conseiller.models';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.css']
})
export class ListClientComponent implements OnInit {

  clients: Client[];
  query:number;
  currentConseiller: Conseiller;
  listeClients: Client[] = []
  constructor(private clientService: ClientService, private conseillerService : ConseillerService) { }

  ngOnInit() {
    this.find();
  }
  /*
  search(id : number){
    this.query=id;
    this.find();

  }*/

find(){
  this.clientService.getAll().subscribe((data: Client[]) => {
    this.clients = data;
  })
}


/*deleteClient(id: number) {
  this.clientService.delete(id).subscribe(() => this.conseillerService.loadClientsParConseiller(this.currentConseiller.id)
       .subscribe(clients => { this.listeClients = clients; }));
 return false;
}*/

}
