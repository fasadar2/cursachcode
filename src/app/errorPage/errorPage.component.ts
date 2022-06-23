// @ts-ignore

import {Component, Inject, Injectable, OnInit} from '@angular/core';
import axios from "axios";
import {ActivatedRoute, Router} from "@angular/router";
export interface PeriodicElement {
  cabinetNumber: string;
  date:string;
  machinenumber:string;
  message:string;
  nameDoctor:string;
}

let ELEMENT_DATA: PeriodicElement[] = [];
@Component({
  selector: 'app-patient-page',
  templateUrl: './errorPage.component.html',
  styleUrls: ['./errorPage.component.css']
})

@Injectable({providedIn: 'root'})
export class ErrorPageComponent implements OnInit {

  public href: string = "";


  displayedColumns: string[] = ['cabinetNumber', 'date', 'machinenumber', 'message','nameDoctor'];
  dataSource = ELEMENT_DATA;

  activate: boolean = false;
  routing: Router;
  route: ActivatedRoute;
  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.routing = router;
    this.route = route;
  }

  ngOnInit(): void {
    this.href = location.href;
    this.GetList2();

  }



  async GetList2() {
//errorTable

    const config = {
      url: 'http://localhost:8081/get/errortable',


    };
    await axios.get(config.url)
      .then((response) => {


        this.dataSource = response.data;
      console.log(ELEMENT_DATA);
        //console.log(this.dataSource);

      })
      .catch((error) => {
        console.log(error);
      });

  }



  RedirectMachine(){
    this.routing.navigate(['enginerpage'])
  }

  RedirectService(){
    this.routing.navigate(['service'])
  }

  RedirectError(){
    this.routing.navigate(['error'])

  }
  Update(){
    this.routing.navigate(['service'])
    this.routing.navigate(['error'])
  }
}
