import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CompteService } from '../services/compte.service';
import { Compte } from '../models/compte.models';
import { ActivatedRoute } from '@angular/router';
import { Client } from '../models/client.models';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-list-comptes',
  templateUrl: './list-comptes.component.html',
  styleUrls: ['./list-comptes.component.css']
})
export class ListComptesComponent implements OnInit {
  
  listeComptes: any;
  client: any;
  constructor(private clientService: ClientService,
     private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(res => {
      this.clientService.getById(+res.id).subscribe(res => {
        this.client = res;
        this.listeComptes = res.listeCompte;
        console.log(this.listeComptes);
      })
    })
  }
  /*
  search(id : number){
    this.query=id;
    this.find();

  }*/
}
