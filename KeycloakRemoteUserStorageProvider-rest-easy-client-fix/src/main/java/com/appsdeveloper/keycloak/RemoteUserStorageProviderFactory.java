package com.appsdeveloper.keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class RemoteUserStorageProviderFactory implements UserStorageProviderFactory<RemoteUserStorageProvider> {

	public static final String PROVIDER_NAME = "my-remote-user-storage-provider3";

	@Override
	public RemoteUserStorageProvider create(KeycloakSession session, ComponentModel model) {

		return new RemoteUserStorageProvider(session, model, new UsersApiLegacyService(session));
	}

	@Override
	public String getId() {
		return PROVIDER_NAME;
	}

}
