import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {initialize} from "./keycloak/utils/keycloak-initializer";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, AppRoutingModule, KeycloakAngularModule, BrowserAnimationsModule],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initialize,
      multi: true,
      deps: [KeycloakService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
