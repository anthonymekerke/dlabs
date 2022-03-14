package fr.univlittoral.dlabs.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implémentation custom
 *
 * @author mxd
 *
 */
@Component
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DlabsAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PasswordBO passwordBO;

	@Autowired
	private UserRepository repo;

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		final String userName = authentication.getName();
		final String password = authentication.getCredentials().toString();

		final UserDO utilisateurEntity = repo.findUserWithName(userName).orElse(null);
		// TODO : Décommentez passwordBO.matches si le mot de passe est crypté.
		if (utilisateurEntity != null /*&& passwordBO.matches(password, utilisateurEntity.getPassword())*/) {

			// Création d'un bean perso pour ajouter des valeurs.
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			final DlabsSpringUser principal = new DlabsSpringUser(userName, password, grantedAuths);

			return new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
		}

		// Arrivé ici alors KO.
		return null;
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
