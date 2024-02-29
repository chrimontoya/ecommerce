import { Injectable } from '@angular/core';
import { LoginDTO } from '../models/dto/loginDTO';

@Injectable({
  providedIn: 'root'
})
export class LocalService {
  user: LoginDTO | null = null;

  constructor() {
    this.getUser();
  }

  setUser(user: LoginDTO) {
    if (typeof sessionStorage !== 'undefined') {
      sessionStorage.setItem("user", JSON.stringify(user));
    }
  }

  getUser(): void {
    if (typeof sessionStorage !== 'undefined') {
      this.user = JSON.parse(sessionStorage.getItem("user")!);
    }
  }

  logOut(): void{
    sessionStorage.clear();
    this.user = null;
    location.reload();
  }

  hasRoleAdmin(){
    if (this.user != null){
      return this.user.roles.indexOf("ROLE_ADMIN") !== -1;
    }
    return false;
  }

  isLoggedIn(){
    return this.user != null;
  }
}
