import { Component, OnInit } from '@angular/core';
import {ParametrageService} from "../services/parametrage.service";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-parametrage',
  templateUrl: './parametrage.component.html',
  styleUrls: ['./parametrage.component.css']
})
export class ParametrageComponent implements OnInit {
  parametrage: any;
  constructor(private parametrageService: ParametrageService, private router: Router) { }

  ngOnInit() {
    this.parametrageService.getParametrage().subscribe(res => {
      console.log(res);
      this.parametrage = res;
    });
  }
  modiferParametre(parametreForm: NgForm) {
    const parametrageModifie = parametreForm.value;
    this.parametrageService.updateParametrage(parametrageModifie).subscribe(res => {
      console.log(res);
    });
    this.router.navigate(['/']);
  }
}
