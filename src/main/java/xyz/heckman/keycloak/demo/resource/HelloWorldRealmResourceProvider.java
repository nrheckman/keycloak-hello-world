package xyz.heckman.keycloak.demo.resource;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class HelloWorldRealmResourceProvider implements RealmResourceProvider {
	private final KeycloakSession session;

	public HelloWorldRealmResourceProvider(KeycloakSession session) {
		this.session = session;
	}

	@Override
	public Object getResource() {
		return new HelloWorldResource(session);
	}

	@Override
	public void close() {
	}
}
