import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { LoginRequest } from 'src/app/models/login-request';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginRequest: LoginRequest;

  constructor(private authService: AuthService) {
    this.loginRequest = new LoginRequest();
  }
  onSubmit(form: NgForm) {
    console.log(this.loginRequest);
    if (form.valid) {
      this.authService.login(this.loginRequest).subscribe(authResposne=>{
        localStorage.setItem('accessToken',authResposne.accessToken);
      })
    }
  }
}
