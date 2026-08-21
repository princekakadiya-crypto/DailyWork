import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { validate } from '@angular/forms/signals';

@Component({
  selector: 'app-login-component',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './login-component.html',
  styleUrl: './login-component.css',
})
export class LoginComponent {
  login:FormGroup=new FormGroup({
    userName:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required])
  });

  submitLogin(){
    console.log(this.login.value);
  }

  get userName(){
    return this.login.get('userName');
  }

  get password(){
    return this.login.get('password');
  }
}
