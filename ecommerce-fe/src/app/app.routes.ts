import {Routes} from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {HomeComponent} from "./pages/home/home.component";
import {AdministratorComponent} from "./pages/administrator/administrator.component";
export const routes: Routes = [
  {path: '', redirectTo: 'inicio', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'inicio', component: HomeComponent},
  {path: 'administrador', component: AdministratorComponent},
];
