import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {CustomKeycloakAuthGuard} from "./keycloak/guard/custom-keycloak-auth-guard";

const routes: Routes = [
  {path: "", canActivate: [CustomKeycloakAuthGuard], component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
