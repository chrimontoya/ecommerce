import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Global} from "../constants/global";
import {ResponseDTO} from "../models/dto/responseDTO";
import {LoginDTO} from '../models/dto/loginDTO';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  logIn(data: any): Observable<ResponseDTO<LoginDTO>> {
    return this.httpClient.post<ResponseDTO<LoginDTO>>(Global.API_URL + '/login', data);
  }

}
