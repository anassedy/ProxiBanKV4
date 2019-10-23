import { Component, OnInit } from '@angular/core';
import {ClientService} from "../services/client.service";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-mes-clients',
  templateUrl: './mes-clients.component.html',
  styleUrls: ['./mes-clients.component.css']
})
export class MesClientsComponent implements OnInit {
  user = JSON.parse(localStorage.getItem('user'));
  clients: any;

  constructor(private clientService: ClientService, private authService: AuthService) {
  }

  ngOnInit() {
    console.log(this.user)
    this.clientService.getClientsByConseiller(this.user.idUser).subscribe(res => {
      this.clients = res;
    }, error => {
      this.authService.verifyError(error);
    });
  }

  deleteClient(id: number) {
    this.clientService.delete(id).subscribe(() => {
      this.ngOnInit();
    });
  }
}
