import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestsPageComponent } from './requests-page/requests-page.component';
import { ImmunizationReportComponent } from './immunization-report/immunization-report.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { VaccinesPageComponent } from './vaccines-page/vaccines-page.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    RequestsPageComponent,
    ImmunizationReportComponent,
    SearchPageComponent,
    VaccinesPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
