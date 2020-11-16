package xyz.heckman.keycloak.demo.resource;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.managers.AppAuthManager;
import org.keycloak.services.managers.AuthenticationManager;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

public class HelloWorldResource {
	private final KeycloakSession session;
	private final AuthenticationManager.AuthResult auth;

	public HelloWorldResource(KeycloakSession session) {
		this.session = session;
		this.auth = new AppAuthManager().authenticateBearerToken(session, session.getContext().getRealm());
	}

	@GET
	@Produces("text/plain; charset=utf-8")
	public String get() {
		String name = session.getContext().getRealm().getDisplayName();
		if (name == null) {
			name = session.getContext().getRealm().getName();
		}
		String username = null;
		if (auth != null) {
			username = auth.getUser().getUsername();

		}
		return "Hello " + name + ": " + username;
	}
}
