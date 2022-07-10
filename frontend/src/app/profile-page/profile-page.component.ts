import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AuthentitacionService } from '../services/autentication/authentitacion.service';
import { ProfileService } from '../services/profile/profile.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  username : string;
  password : string;
  firstName : string;
  lastName : string;
  dateOfBirth : string;
  salary : number;

  user : User;


  constructor(
    public router: Router,
    private authService: AuthentitacionService,
    private profileService : ProfileService
  ) { }

  ngOnInit(): void {

    this.user = this.authService.getAuthorizationToken().user;

      if (this.user !== null) {
        this.username = this.user.email;
        this.lastName = this.user.prezime;
        this.firstName = this.user.ime;

        const datePipe = new DatePipe('en-US');
        this.dateOfBirth = datePipe.transform(this.user.rodjendan, 'dd/MM/yyyy') || "";

      }
  }

  alertuj(text : string){
    alert(text);
  }

}
