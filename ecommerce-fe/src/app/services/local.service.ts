import {Injectable} from '@angular/core';
import {LoginDTO} from '../models/dto/loginDTO';

@Injectable({
  providedIn: 'root'
})
export class LocalService {

  setUser(user: LoginDTO) {
    sessionStorage.setItem("user", JSON.stringify(user));
  }

  getUser(): LoginDTO | null {
    return JSON.parse(sessionStorage.getItem("user")!);
  }

}
