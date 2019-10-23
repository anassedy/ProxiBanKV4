import { Injectable, ErrorHandler } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ErreurService {

  constructor() { }
}
class MyErrorHandler implements ErrorHandler {
  handleError(error) {
    error;
  }
} 
