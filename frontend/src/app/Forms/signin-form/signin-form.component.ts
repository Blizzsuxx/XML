import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthentitacionService } from '../../services/autentication/authentitacion.service';//'../../../app//model/service/auth-service/authentication.service';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-signin-form',
  templateUrl: './signin-form.component.html',
  styleUrls: ['./signin-form.component.css']
})
export class SigninFormComponent implements OnInit {

  access_token = null; 
  signinForm: FormGroup;
  userToSignUp: User;

  constructor(
    public router: Router,
    private authService: AuthentitacionService,
    private datePipe: DatePipe
  ) { }

  ngOnInit() {
    this.signinForm = new FormGroup({
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)]),
      'ime': new FormControl(null, [Validators.required]),
      'prezime': new FormControl(null, [Validators.required]),
      'jmbg': new FormControl(null, [Validators.required, Validators.pattern("[0-9]{13}")]),
      'rodjendan': new FormControl(null, [Validators.required])
    });
  }

  signup() {
    console.log("rodjendan")
      const rodjendan = this.datePipe.transform(this.signinForm.value.rodjendan, 'yyyy-MM-dd');
      if(rodjendan != null){
        this.userToSignUp = new User(
          this.signinForm.value.username,  
          this.signinForm.value.password,
          this.signinForm.value.ime,
          this.signinForm.value.prezime,
          this.signinForm.value.jmbg,
          rodjendan
          
        )
  
        this.authService.signup(this.userToSignUp)
      }
      
  }

}
