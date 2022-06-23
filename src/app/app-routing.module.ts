import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {EnginerPageComponent} from "./enginerPage/enginerPage.component";
import {MachineServicecomponent} from "./machineService/machineServicecomponent";
import {ErrorPageComponent} from "./errorPage/errorPage.component";
import {DoctorPageComponent} from "./doctorPage/doctorPage.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'enginerpage',
    component: EnginerPageComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path:'service',
    component: MachineServicecomponent
  },
  {
    path:'error',
    component: ErrorPageComponent
  },
  {
    path:'doctorpage',
    component: DoctorPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
