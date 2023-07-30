import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthResponse } from './auth-response';
import { LoginRequest } from '../models/login-request';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private loginUrl: string;
  constructor(private http: HttpClient) {
      this.loginUrl='http://localhost:8080/api/auth/login';
  }

  public login(loginRequest: LoginRequest): Observable<any> {
    return this.http.post<AuthResponse>(this.loginUrl, loginRequest);
  }

  public logout(){
    localStorage.removeItem("accessToken");
  }

  public isLoggedIn(): boolean{
    const isLoggedIn = localStorage.getItem("accessToken");
    if(isLoggedIn!=null){
      return true;
    }else{
      return false
    }
  }
}
