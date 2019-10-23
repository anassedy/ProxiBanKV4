import { Component, OnInit } from '@angular/core';
import {Conseiller} from "../models/conseiller.models";
import {ConseillerService} from "../services/conseiller.service";
import {NgForm} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../services/client.service";

@Component({
  selector: 'app-affectation-client-conseiller',
  templateUrl: './affectation-client-conseiller.component.html',
  styleUrls: ['./affectation-client-conseiller.component.css']
})
export class AffectationClientConseillerComponent implements OnInit {
  conseillers: any;
  idClient: any
  constructor(private conseillerService: ConseillerService, private route: ActivatedRoute, private clientService: ClientService, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idClient = params.id;
    });
    this.conseillerService.getAll().subscribe(res => {
      this.conseillers = res;
    });
  }
  affecter(id: number) {
    this.clientService.affecterConseiller(id, this.idClient).subscribe(res => {
      this.router.navigate(['/list_client']);
    });

  }

}
