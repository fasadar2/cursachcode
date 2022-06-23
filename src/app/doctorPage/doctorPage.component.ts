import { Component, OnInit } from '@angular/core';
import axios from "axios";
export interface PeriodicElement {
  date: string
  machinename:string
  cabinet:string
}

let ELEMENT_DATA: PeriodicElement[] = [];
@Component({
  selector: 'app-patient-page',
  templateUrl: './doctorPage.component.html',
  styleUrls: ['./doctorPage.component.css']
})

export class DoctorPageComponent implements OnInit {
  displayedColumns: string[] = ['date', 'machinename', 'cabinet'];
  dataSource = ELEMENT_DATA;
  constructor() { }

  ngOnInit(): void {
    this.GetList()
  }
  async GetList() {

    const config = {
      url: 'http://localhost:8081/doctor/timetable',
      list:[]
    };
    await  axios.get(config.url)
      .then((response) => {
        console.log(response.data);
        this.dataSource = response.data;

      })
      .catch((error) => {
        console.log(error);
      });

  }
}
