package fr.univlittoral.dlabs.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Extends du user spring (org.springframework.security.core.userdetails.User) si besoin d'ajout d'informations
 * @author Max
 *
 */
public class DlabsSpringUser extends User {

	private static final long serialVersionUID = -2836522345185404025L;

	public DlabsSpringUser(final String username, final String password, final Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

}
