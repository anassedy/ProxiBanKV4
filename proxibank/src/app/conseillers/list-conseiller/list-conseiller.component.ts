import { Component, OnInit, ErrorHandler } from '@angular/core';
import { Conseiller } from '../../models/conseiller.models';
import { ConseillerService } from 'src/app/services/conseiller.service';
import { Client } from 'src/app/models/client.models';



@Component({
  selector: 'app-list-conseiller',
  templateUrl: './list-conseiller.component.html',
  styleUrls: ['./list-conseiller.component.css']
})
export class ListConseillerComponent implements OnInit {
conseillers:Conseiller[];
query:string;

  constructor(private conseillerService: ConseillerService) { }

  ngOnInit() {
   this.find();
  }
  /* search(keyword:string){
    this.query=keyword;
    this.find();

  } */
find(){
  this.conseillerService.getAll().subscribe((data: Conseiller[]) => {
    this.conseillers = data;
    console.log(this.conseillers);
  })
}
deleteConseiller(id: number){
  this.conseillerService.delete(id).subscribe(() => {
    this.find();
  }

  )
}

}
