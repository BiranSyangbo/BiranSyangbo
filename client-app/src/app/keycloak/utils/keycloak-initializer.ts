import {KeycloakService} from "keycloak-angular";
import {environment} from "../../../environments/environment";

export function initialize(keycloak: KeycloakService): () => Promise<boolean> {
  return () =>
    keycloak.init({
      config: {
        url: environment.keycloak.issuer_url,
        realm: environment.keycloak.realm,
        clientId: environment.keycloak.client_id
      },
      initOptions: {
        onLoad: 'check-sso',
        checkLoginIframe: true,
        checkLoginIframeInterval:30,
        pkceMethod: "S256",
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      },
      bearerExcludedUrls: ["/assets"]
    });
}
