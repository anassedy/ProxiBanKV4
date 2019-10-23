import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';

import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router) { }
  login(username: string, password: string) {
    const login = {
      username,
      password
    };
    return this.http.post(
      'http://localhost:8080/login', login);
  }

  loggedIn() {
    return !!localStorage.getItem('token');
  }
  logout() {
    localStorage.clear();
    this.router.navigate(['/authentification']);
  }

  getToken() {
    return localStorage.getItem('token');
  }
  verifyError(err) {
    if (err instanceof HttpErrorResponse) {
      return this.router.navigate(['/accueil']);
    }
  }
}

