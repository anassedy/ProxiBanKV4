import {Injectable, Injector} from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpParams, HttpRequest} from '@angular/common/http';

import {Observable} from 'rxjs';

import {Router} from '@angular/router';
import {AuthService} from "./auth.service";

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {
  private loginService = this.injector.get(AuthService);
  constructor(private injector: Injector, private router: Router) { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

      const token = this.loginService.getToken();
      if (token) {
        request = request.clone({
          setHeaders: {
            Authorization: this.loginService.getToken()
          }
        });
      }
      return next.handle(request);

  }
 /* private handle401Error(request: HttpRequest<any>, next: HttpHandler) {
     this.router.navigate(['/home']);
  }*/
}

