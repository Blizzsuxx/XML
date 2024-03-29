import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './Forms/login-form/login-form.component';

import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser'
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { InteresovanjeComponent } from './Forms/interesovanje/interesovanje.component';
import { SigninFormComponent } from './Forms/signin-form/signin-form.component';
import { SaglasnostComponent } from './Forms/saglasnost/saglasnost.component';
import { ZeleniSertifikatComponent } from './Forms/zeleni-sertifikat/zeleni-sertifikat.component';
import { IzvestajOImunizacijiComponent } from './Forms/izvestaj-o-imunizaciji/izvestaj-o-imunizaciji.component';
import { IzlistajDokumenteComponent } from './Forms/izlistaj-dokumente/izlistaj-dokumente.component';
import { DokumentComponent } from './Forms/dokument/dokument.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'login', 
    pathMatch: 'full'
  },

  {
    path: 'login',
    component: LoginFormComponent,
  },

  {
    path: 'izvestaj-o-imunizaciji',
    component: IzvestajOImunizacijiComponent,
  },

  {
    path: 'signin',
    component: SigninFormComponent
  },

  {
    path: 'interesovanje',
    component: InteresovanjeComponent,
  },

  {
    path: 'saglasnost',
    component: SaglasnostComponent
  },

  {
    path: 'zeleni-sertifikat',
    component: ZeleniSertifikatComponent
  },

  {
    path: 'navbar',
    component: NavBarComponent,
  },

  {
    path: 'profile',
    component: ProfilePageComponent,
  },

  {
    path: 'change-password',
    component: ChangePasswordFormComponent,
  },

  {
    path: 'izlistaj-dokumente',
    component: IzlistajDokumenteComponent,
  },
  {
    path: 'dokument/:type',
    component: DokumentComponent,
  }


];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes) ],
  declarations: [],
  providers: [],
  // bootstrap: [AppComponent]
  exports: [RouterModule,BrowserModule ]
  
})

export class AppRoutingModule { }
