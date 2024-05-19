import { Routes } from '@angular/router';
import { AuthComponent } from './pages/auth/auth.component';

export const routes: Routes = [
    { path: '**', redirectTo: 'iniciar-sesion', pathMatch: 'full'},
    { path: 'iniciar-sesion', component: AuthComponent, title: 'iniciar sesión' }
];
