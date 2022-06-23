import {Component, Inject, Injectable, OnInit} from '@angular/core';
import axios from "axios";
import {ActivatedRoute, Router} from "@angular/router";

export interface PeriodicElement {
  dos:string
  dose:string
  id:string
  serial:string
  status:string
  message:string
}

let ELEMENT_DATA: PeriodicElement[] = [];
@Component({
  selector: 'app-patient-page',
  templateUrl: './machineService.component.html',
  styleUrls: ['./machineService.component.css']
})
@Injectable({providedIn: 'root'})
export class MachineServicecomponent implements OnInit {
  activate: boolean = false;
  routing: Router;
  route: ActivatedRoute;
  displayedColumns: string[] = ['dos', 'dose', 'id', 'serial','status','message'];
  dataSource = ELEMENT_DATA;
  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.routing = router;
    this.route = route;

  }
  str :string = "";

  list:{
    dos:string
    dose:string
    id:string
    serial:string
    status:string
  message:string}[]=[];
  i: number = 0;
  ngOnInit(): void {
    this.GetList2();
  }


  async GetList2() {
//errorTable

    const config = {
      url: 'http://localhost:8081/service/servicemachinelist',


    };
   await axios.get(config.url)
      .then((response) => {
        this.dataSource = response.data;



      })
      .catch((error) => {
        console.log(error);
      });

  }
  PostService(){
    const config = {
      url: 'http://localhost:8081/service/machine',

    };
    const status :HTMLInputElement = document.getElementById('Status') as HTMLInputElement;
    const inventoryid :HTMLInputElement = document.getElementById('serialid2') as HTMLInputElement;
    const errorid :HTMLInputElement = document.getElementById('errorid') as HTMLInputElement;
    const ToES :HTMLInputElement = document.getElementById('ToES') as HTMLInputElement;
    const ToSS :HTMLInputElement = document.getElementById('ToSS') as HTMLInputElement;

    const data = {
      status: status.value,
      id:inventoryid.value,
      errorid: errorid.value,
      ToES:ToES.value,
      ToSS:ToSS.value
    }
    console.log(data);
    axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true } })
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
        }
        if (response.data == 2) {
          alert('Проверьте серийный номер');
        }
        if (response.data == 3) {
          alert('Даный сериный номер уже используется');
        }
        if (response.data == 4) {
          alert('проверьте ид ошибки');
        }
        if (response.data == 5) {
          alert('Такого ид ошибки не существует');
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Ошибка сервера');
      });
  }
  ChangeService(){
    const config = {
      url: 'http://localhost:8081/service/updatemachine',

    };
    const status :HTMLInputElement = document.getElementById('c_status') as HTMLInputElement;
    const inventoryid :HTMLInputElement = document.getElementById('id') as HTMLInputElement;
    const ToES :HTMLInputElement = document.getElementById('ChangeToES') as HTMLInputElement;

    const data = {
      status: status.value,
      id:inventoryid.value,
      ToES:ToES.value
    }
    console.log(data);
    axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true } })
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Ошибка сервера');
      });
  }
  CreateReport(){
    const email :HTMLInputElement = document.getElementById('email') as HTMLInputElement;
    const config = {
      url: 'http://localhost:8081/service/report',

    };
    const data = {
      email:email.value

    }
    axios.post(config.url,data)
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
        }
        if (response.data == 2) {
          alert('Проверьте введенный email');
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Ошибка сервера');
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
}
