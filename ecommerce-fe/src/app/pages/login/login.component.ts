import {Component} from '@angular/core';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButton} from "@angular/material/button";
import {LoginService} from "../../services/login.service";
import {LocalService} from "../../services/local.service";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatButton, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  formLogin: FormGroup = new FormGroup({
    username: new FormControl(),
    password: new FormControl(),
  });

  constructor(
    private loginService: LoginService,
    private localService: LocalService,
  ) {
  }

  login() {
    this.loginService.logIn(this.formLogin.value)
      .subscribe({
        next: (res) => {
          this.localService.setUser(res.data);
        }
      });
  }

}
