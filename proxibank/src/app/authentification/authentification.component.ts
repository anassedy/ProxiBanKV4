import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { NgForm, FormBuilder, FormGroup } from '@angular/forms';
import {User} from "../models/user.model";

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) {
  }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    const user = form.value
    console.log(user);
    this.auth.login(user.username, user.password).subscribe((res: User) => {
      if (res.token) {
        localStorage.setItem('token', res.token);
        const log = {idUser: res.idUser, username: res.username, role: res.role};
        localStorage.setItem('user', JSON.stringify(log));
        if (res.role === 'CONSEILLER') {
          this.router.navigate(['/mesclients']);
        } else if (res.role === 'GERANT') {
          this.router.navigate(['/list_conseiller']);
        }
      }
    });
  }
}
