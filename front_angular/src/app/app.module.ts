import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { DealCardComponent } from './deal-card/deal-card.component';
import { DealPageComponent } from './deal-page/deal-page.component';
import { DealListComponent } from './deal-list/deal-list.component';
import { DealFormComponent } from './deal-form/deal-form.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    DealCardComponent,
    DealPageComponent,
    DealListComponent,
    DealFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
