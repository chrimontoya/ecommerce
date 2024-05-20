import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { CustomResponse } from '../models/custom-response.model';
import { AuthModel } from '../models/auth.model';
import { UserModel } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string = "http://localhost:8000/api/v1/auth/login"

  constructor(
    private httpClient: HttpClient,
    private router: Router,
  ) { }

  logIn(username: string, password: string){
    this.httpClient.post<CustomResponse<AuthModel>>(this.url,{ username, password}).subscribe({
      next: (res) => {
        if (!Array.isArray(res.data)){
          sessionStorage.setItem('token', res.data.token);
          sessionStorage.setItem('user', JSON.stringify(res.data.user));
        }
      }
    });
  }

  logOut(){
    sessionStorage.clear();
  }

  getUser(){
    return JSON.parse(sessionStorage.getItem('user')!) as UserModel;
  }

}
