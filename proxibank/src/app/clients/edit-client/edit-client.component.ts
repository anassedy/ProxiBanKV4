import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';


@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {
  userForm : FormGroup;
  constructor(private fb : FormBuilder, private activeRoute: ActivatedRoute, private clientService: ClientService, private router: Router) { }

  ngOnInit() {
    this.userForm = this.fb.group({
      id:[''],
      nom: [''],
      prenom: [''],
      email: [''],
      adresse:[''],
    });
    this.activeRoute.params.subscribe( p => {
      this.clientService.getById(p.id).subscribe( client => {
      this.userForm.setValue(client)
      })
    })
  }
  onSubmit(){
    this.clientService.update(this.userForm.value).subscribe(() =>{
      alert('Les informatiosn de ce clients ont été modifiée avec succès');
      this.router.navigate(['/list_client']);
    });
  }

}
