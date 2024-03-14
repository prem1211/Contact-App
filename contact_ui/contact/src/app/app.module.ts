import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CreatecontactComponent } from './createcontact/createcontact.component';

import { ContacteditComponent } from './contactedit/contactedit.component';
import { FormsModule } from '@angular/forms';
import { ContactlistComponent } from './contactlist/contactlist.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatecontactComponent,
    ContacteditComponent,
    ContactlistComponent,
  ],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
