import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string = "http://localhost:8000/api/v1/auth/login"

  constructor(
    private httpClient: HttpClient
  ) { }

  logIn(username: string, password: string): Observable<any>{
    return this.httpClient.post<any>(this.url,{ username, password});
  }

}
