import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Conseiller } from 'src/app/models/conseiller.models';
import { ConseillerService } from 'src/app/services/conseiller.service';
import { Client } from 'src/app/models/client.models';

@Component({
  selector: 'app-create-conseiller',
  templateUrl: './create-conseiller.component.html',
  styleUrls: ['./create-conseiller.component.css']
})
export class CreateConseillerComponent implements OnInit {

  constructor(private conseillerService : ConseillerService, private router: Router) { }

  ngOnInit() {
  }
  onSubmit(conseillerForm : NgForm) {
     const conseiller = conseillerForm.value;
     this.conseillerService.create(conseiller).subscribe((data: Conseiller) => {
       this.router.navigate(["/list_conseiller"]);
    });
  }
}
