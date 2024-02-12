import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Global} from "../constants/global";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private httpClient: HttpClient
  ) { }

  logIn(data: any):Observable<any>{
    return this.httpClient.post<any>(Global.API_URL + '/login', data);
  }
  
}
