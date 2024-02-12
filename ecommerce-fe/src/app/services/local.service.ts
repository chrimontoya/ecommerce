import { Injectable } from '@angular/core';
import { LoginDTO } from '../models/dto/loginDTO';

@Injectable({
  providedIn: 'root'
})
export class LocalService {

  setUser(user: LoginDTO) {
    if (typeof sessionStorage !== 'undefined') {
      sessionStorage.setItem("user", JSON.stringify(user));
    }
  }

  getUser(): LoginDTO | null {
    if (typeof sessionStorage !== 'undefined') {
      const userString = sessionStorage.getItem("user");
      return userString ? JSON.parse(userString) : null;
    }
    return null;
  }
}
