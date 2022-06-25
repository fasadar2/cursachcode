// @ts-ignore
// @ts-ignore

import {Component, Inject, Injectable, OnInit} from '@angular/core';
import axios from 'axios';
import {ActivatedRoute, Router} from "@angular/router";

export interface PeriodicElement {
  type: string
  lastTO:string
  futerTO:string
  inventoryId:string
}

let ELEMENT_DATA: PeriodicElement[] = [];
@Component({

  selector: 'app-login',
  templateUrl: `./enginerPage.component.html`,
  styleUrls: ['./enginerPage.component.css'],

})
@Injectable({providedIn: 'root'})
export class EnginerPageComponent implements OnInit {
  activate: boolean = false;
  routing: Router;
  route: ActivatedRoute;
  displayedColumns: string[] = ['type', 'lastTO', 'futerTO', 'inventoryId'];
  dataSource = ELEMENT_DATA;
  public href: string = "";

  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.routing = router;
    this.route = route;
  }

  ngOnInit(): void {
    this.href = location.href;
    this.GetList();

  }
  PostOK() {
    const config = {
      url: 'http://localhost:8081/machine/status',

    };
    const id :HTMLInputElement = document.getElementById('id') as HTMLInputElement;

    const data = {
      machine: id.value,
      is: '1'

    }
    console.log(data);
    axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true } })
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
        }
        if(response.data == 2){
          alert('Проверьте написание, возможно id написан неверно')
        }
        if(response.data == 3){
          alert('Несуществующий ID')
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Ошибка сервера');
      });


  }

  PostFuck() {
    const config = {
      url: 'http://localhost:8081/machine/status',

    };
    const id :HTMLInputElement = document.getElementById('id') as HTMLInputElement;
    const data = {
      machine: id.value,
      is: '2'
    }
    console.log(data);
    axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true } })
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
        }
        if(response.data == 2){
          alert('Проверьте написание, возможно id написан неверно')
        }
        if(response.data == 3){
          alert('Несуществующий ID')
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Ошибка сервера');
      });


  }


  PostNewMachine() {
    const config = {
      url: 'http://localhost:8081/new/machine',

    };
    const machinetype :HTMLInputElement = document.getElementById('typemachine') as HTMLInputElement;
    const inventoryid :HTMLInputElement = document.getElementById('inventoryid') as HTMLInputElement;
    const recomendation :HTMLInputElement = document.getElementById('recomendationmachine') as HTMLInputElement;
    const dateNTO :HTMLInputElement = document.getElementById('dateNTO') as HTMLInputElement;
    const dateDSE :HTMLInputElement = document.getElementById('dateDSE') as HTMLInputElement;
    const dateDEE :HTMLInputElement = document.getElementById('dateDEE') as HTMLInputElement;
    const data = {
      machine: machinetype.value,
      id:inventoryid.value,
      recomendation: recomendation.value,
      dateNTO: dateNTO.value,
      dateDSE: dateDSE.value,
      dateDEE: dateDEE.value
    }
    console.log(data);
    axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true } })
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
        }
        if (response.data == 2) {
          alert('Проверьте ввод серийного номера');
        }
        if (response.data == 3) {
          alert('Данный серийный номер уже зарегестрированн');
        }
        if (response.data == 4) {
          alert('Несуществующий тип');
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Ошибка сервера');
      });


  }

  async GetList() {

    const config = {
      url: 'http://localhost:8081/get/machinelist',
      list:[]
    };
  await  axios.get(config.url)
      .then((response) => {
        //console.log(response.data);
        this.dataSource = response.data;

      })
      .catch((error) => {
        console.log(error);
      });

  }
  UpdateTO(){
    const config = {
      url: 'http://localhost:8081/machine/to',

    };
    const lastTO :HTMLInputElement = document.getElementById('lastTO') as HTMLInputElement;
    const id2 :HTMLInputElement = document.getElementById('id2') as HTMLInputElement;
    const data = {
      lastTO: lastTO.value,
      id:id2.value,

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
      })
      .catch((error) => {
        console.log(error);
        alert('Ошибка сервера');
      });
  }

  PostRec() {
    const config = {
      url: 'http://localhost:8081/machine/recomendation',

    };
    const id :HTMLInputElement = document.getElementById('ser') as HTMLInputElement;
    const recomendation :HTMLInputElement = document.getElementById('rec') as HTMLInputElement;
    const data = {
      serial: id.value,
      recomendation: recomendation.value
    }
    console.log(data);
    axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true } })
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
        }
        if(response.data == 2){
          alert('Проверьте написание, возможно id написан неверно')
        }
        if(response.data == 3){
          alert('Несуществующий ID')
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
