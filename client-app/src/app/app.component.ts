import { Component } from '@angular/core';
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'client-app';

  constructor(private keycloakService: KeycloakService) {
  }
  logout() {
      this.keycloakService.logout();
  }
}
