import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DealListComponent } from './deal-list/deal-list.component';
import { DealPageComponent } from './deal-page/deal-page.component';
import { DealFormComponent } from './deal-form/deal-form.component';

const routes: Routes = [
  { path: '', redirectTo: '/dlabs', pathMatch: 'full' },
  { path: 'dlabs', component: DealListComponent},
  { path: 'dlabs/form', component: DealFormComponent},
  { path: 'dlabs/:id', component: DealPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
