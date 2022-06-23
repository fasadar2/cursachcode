import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import {ErrorPageComponent} from "./errorPage/errorPage.component";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import {MatSelectModule} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import { PatientPageComponent } from './patient-page/patient-page.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatNativeDateModule} from "@angular/material/core";
import {EnginerPageComponent} from "./enginerPage/enginerPage.component";
import {MachineServicecomponent} from "./machineService/machineServicecomponent";
import {MatTableModule} from "@angular/material/table";
import {DoctorPageComponent} from "./doctorPage/doctorPage.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PatientPageComponent,
    EnginerPageComponent,
    ErrorPageComponent,
    MachineServicecomponent,
    DoctorPageComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatFormFieldModule,
        MatIconModule,
        MatSelectModule,
        MatInputModule,
        MatButtonModule,
        MatDatepickerModule,
        ReactiveFormsModule,
        MatDatepickerModule,
        MatNativeDateModule,
        FormsModule,
        MatTableModule
    ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
