package xyz.heckman.keycloak.demo.resource;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class HelloWorldRealmResourceProviderFactory implements RealmResourceProviderFactory {
	private static final String HELLO = "hello";

	@Override
	public HelloWorldRealmResourceProvider create(KeycloakSession session) {
		return new HelloWorldRealmResourceProvider(session);
	}

	@Override
	public void init(Config.Scope config) {
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {
	}

	@Override
	public void close() {
	}

	@Override
	public String getId() {
		return HELLO;
	}
}
