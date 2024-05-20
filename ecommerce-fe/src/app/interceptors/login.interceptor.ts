import { HttpInterceptorFn } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const loginInterceptor: HttpInterceptorFn = (req, next) => {
  const router = new Router();
  const token = sessionStorage.getItem('token');

  if (token) {
    req.clone({
      headers: req.headers.set('Authorization', `Bearer ${token}`),
    });
    router.navigate(['ecommerce']);
  }

  return next(req).pipe(
    catchError((err) => {
      if (!sessionStorage.getItem('token')) {
        router.navigate(['iniciar-sesion']);
      }
      return throwError(() => new Error('Unauthorized Exception'));
    })
  );
};
