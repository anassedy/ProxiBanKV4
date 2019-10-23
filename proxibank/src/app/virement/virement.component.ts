import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, NgForm} from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { VirementService } from '../services/virement.service';
import { CompteService } from '../services/compte.service';
import { Operation } from '../models/oprerations.models';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {
  operation: Operation;
  constructor(private serviceVirement: VirementService,
    private formBuilder: FormBuilder,
    private compteService : CompteService,
    private router: Router,
    private activeRoute: ActivatedRoute) { }

  ngOnInit() {
    }
    faireVirement(detail: NgForm) {
      let detailvirement = {
        compte1: detail.value.idEmetteur,
        compte2: detail.value.idRecepteur,
        montant: detail.value.montant,
        compteAgence: 1,
        id : 1
     
     
      }
     console.log(detailvirement)
       this.serviceVirement.operationVirement(detailvirement).subscribe(() =>{
       alert('Le virement a été enregistré avec succès');
       this.router.navigate(['/virement']);
     });
     }

}
