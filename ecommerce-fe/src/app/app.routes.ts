import { Routes } from '@angular/router';
import { AuthComponent } from './pages/auth/auth.component';
import { HomeComponent } from './pages/home/home.component';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: 'iniciar-sesion', component: AuthComponent },
  { path: 'ecommerce', component: HomeComponent, canActivate: [authGuard] },
];
