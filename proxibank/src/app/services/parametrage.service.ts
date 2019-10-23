import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ParametrageService {

  constructor(private http: HttpClient) { }

  getParametrage() {
    return this.http.get('http://localhost:8080/parametrage/1');
  }
  updateParametrage(parametrage) {
    return this.http.put('http://localhost:8080/parametrage/1', parametrage);
  }
}
