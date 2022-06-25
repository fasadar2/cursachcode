import {Component, Inject, Injectable, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import axios from 'axios';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
@Injectable({providedIn: 'root'})
export class LoginComponent implements OnInit {

  activate: boolean = false;
  routing: Router;
  route: ActivatedRoute;

  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.routing = router;
    this.route = route;
  }

  ngOnInit(): void {}

  PostLog() {
    const config = {
      url: 'http://localhost:8081/user/login',

    };
    const log :HTMLInputElement = document.getElementById('log') as HTMLInputElement;
    const password :HTMLInputElement = document.getElementById('password') as HTMLInputElement;
    const data = {
      log: log.value,
      password: password.value,
    }

    axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true } })
      .then((response) => {
        console.log(response);
        if (response.data == 1) {
          alert('Успешно!');
          this.routing.navigate(['enginerpage'])
        }
        if (response.data == 2) {
          alert('Успешно!');
          this.routing.navigate(['doctorpage'])
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Неверный логин или пароль!');
      });


}
}
