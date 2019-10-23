import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isAuth = false;
  constructor(private route: Router, private authService: AuthService) { }

  ngOnInit() {
    this.isAuth = localStorage.getItem("token") ? true : false ;
  }
  logout() {
    this.authService.logout();
    this.ngOnInit();
  }
}
