import { ActivatedRouteSnapshot, CanActivateFn, RouterStateSnapshot, Router } from "@angular/router";
import { LocalService } from "../services/local.service";
import {inject} from "@angular/core";

export const authGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot) => {

  const localService = inject(LocalService);
  return localService.getUser() != null;
};
