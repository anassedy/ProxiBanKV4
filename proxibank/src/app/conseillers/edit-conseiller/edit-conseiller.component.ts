import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ConseillerService } from 'src/app/services/conseiller.service';


@Component({
  selector: 'app-edit-conseiller',
  templateUrl: './edit-conseiller.component.html',
  styleUrls: ['./edit-conseiller.component.css']
})
export class EditConseillerComponent implements OnInit {
  userForm : FormGroup;
  constructor(private fb : FormBuilder, private activeRoute: ActivatedRoute, private conseillerService: ConseillerService, private router: Router) { }

  ngOnInit() {
    this.userForm = this.fb.group({
      id:[''],
      nom: [''],
      prenom: [''],
      email: [''],
      adresse:[''],
    });
    this.activeRoute.params.subscribe( p => {
      this.conseillerService.getById(p.id).subscribe( conseiller => {
      this.userForm.setValue(conseiller)
      })
    })
  }
  onSubmit(){
    this.conseillerService.update(this.userForm.value).subscribe(() =>{
      this.router.navigate(['/list_conseiller']);
    });
  }

}
