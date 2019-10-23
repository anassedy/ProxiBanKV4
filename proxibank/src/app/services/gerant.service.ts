import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../models/client.models';
import { environment } from 'src/environments/environment';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class GerantService {
/* le gérant va consulter la liste des clients par conseiller est va affecter pour chaque client un conseiller */
  constructor(private httpclient : HttpClient) { }
 
}
