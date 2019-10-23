import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';
import { NgForm } from '@angular/forms';
import { Client } from 'src/app/models/client.models';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {
  user = JSON.parse(localStorage.getItem('user'));
  constructor(private clientService : ClientService, private router: Router) { }

  ngOnInit() {
  }
  onSubmit(clientForm: NgForm) {
    const client = clientForm.value;
    this.clientService.create(client, this.user.idUser).subscribe(data => {
      alert('Le client a été enregistré avec succès');
      this.router.navigate(["/mesclients"]);
    });
  }
}
