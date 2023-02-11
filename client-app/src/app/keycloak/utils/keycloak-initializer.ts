import {KeycloakService} from "keycloak-angular";

export function initialize(keycloak: KeycloakService): () => Promise<boolean> {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'keycloak-test',
        clientId: 'keycloak-test'
      },
      initOptions: {
        onLoad: 'check-sso',
        checkLoginIframe: false,
        pkceMethod: "S256"
        // silentCheckSsoRedirectUri:
        //   window.location.origin + '/assets/silent-check-sso.html'
      },
      bearerExcludedUrls: ["/assets"]
    });
}
