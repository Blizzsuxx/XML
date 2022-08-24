import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ImmunizationReportComponent } from './immunization-report/immunization-report.component';
import { RadnikComponent } from './radnik/radnik.component';
import { RequestsPageComponent } from './requests-page/requests-page.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { VaccinesPageComponent } from './vaccines-page/vaccines-page.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'requests',
    pathMatch: 'full'
  },
  {
    path: 'requests',
    component: RequestsPageComponent 
  },
  {
    path: 'radnik',
    component: RadnikComponent
  },
  {
    path: 'search',
    component: SearchPageComponent
  },
  {
    path: 'vaccines',
    component: VaccinesPageComponent
  },
  {
    path: 'report',
    component: ImmunizationReportComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  declarations: [],
  providers: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
