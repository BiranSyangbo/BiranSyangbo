import {Injectable} from "@angular/core";
import {CustomAuthGuard} from "./custom-auth-guard";
import {ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {AuthGuard} from "./auth-guard";


@Injectable({
  providedIn: 'root'
})
export class CustomKeycloakAuthGuard implements CustomAuthGuard {
  constructor(private authGuard: AuthGuard) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.authGuard.canActivate(route, state);
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.authGuard.canActivate(childRoute, state);
  }

}
