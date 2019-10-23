import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { Operation } from '../models/oprerations.models';

@Injectable({
  providedIn: 'root'
})
export class VirementService {

  constructor(private httpclient : HttpClient) { }
  operationVirement(virement){
    return this.httpclient.put<Operation[]> (environment.serverUrl + "virement", virement)
  }
  
}
