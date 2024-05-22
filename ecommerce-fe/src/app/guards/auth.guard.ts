import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = () => {
  const router = new Router();

  if (!sessionStorage.getItem('token')) {
    router.navigate(['iniciar-sesion']);
    return false;
  }
  return true;
};
