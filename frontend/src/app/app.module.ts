import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { CreateCookComponent } from './cook/create-cook/create-cook.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { LoginFormComponent } from './Forms/login-form/login-form.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { AuthInterceptor } from './services/autentication/auth.interceptor';
import { MatTableModule } from '@angular/material/table';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';

import {MatBottomSheet, MatBottomSheetModule, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { MatCardModule } from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import { MatSortModule } from '@angular/material/sort';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import {MatInputModule} from '@angular/material/input';
import {DragDropModule} from '@angular/cdk/drag-drop';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import { DatePipe } from '@angular/common';
import { InteresovanjeComponent } from './Forms/interesovanje/interesovanje.component';
import {MatCheckboxModule} from '@angular/material/checkbox'; 
import {MatFormFieldModule} from '@angular/material/form-field'; 
import { MatSelectModule } from '@angular/material/select';
import { SigninFormComponent } from './Forms/signin-form/signin-form.component';
import { SaglasnostComponent } from './Forms/saglasnost/saglasnost.component';
import {MatRadioModule} from '@angular/material/radio';
import { EditorModule } from '@tinymce/tinymce-angular';
import { ZeleniSertifikatComponent } from './Forms/zeleni-sertifikat/zeleni-sertifikat.component';
import { IzvestajOImunizacijiComponent } from './Forms/izvestaj-o-imunizaciji/izvestaj-o-imunizaciji.component';
import { IzlistajDokumenteComponent } from './Forms/izlistaj-dokumente/izlistaj-dokumente.component';
import { DokumentComponent } from './Forms/dokument/dokument.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    NavBarComponent,
    ProfilePageComponent,
    ChangePasswordFormComponent,
    InteresovanjeComponent,
    SigninFormComponent,
    SaglasnostComponent,
    ZeleniSertifikatComponent,
    IzvestajOImunizacijiComponent,
    IzlistajDokumenteComponent,
    DokumentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatTableModule,
    MatSidenavModule,
    MatButtonModule,
    MatCardModule,
    MatBottomSheetModule,
    MatIconModule,
    MatBadgeModule,
    MatSortModule,
    MatSnackBarModule,
    MatInputModule,
    DragDropModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatSelectModule,
    MatRadioModule,
    EditorModule
    
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass : AuthInterceptor,
      multi : true,
      
    },
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
