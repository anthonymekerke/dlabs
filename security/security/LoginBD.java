package fr.univlittoral.dlabs.security;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.tgi.portail.bean.dto.UtilisateurDTO;
import net.tgi.portail.bean.dto.request.LoginRequestDTO;
import net.tgi.portail.mapper.UtilisateurMapper;

/**
 * @author MDE
 *
 */
 // TODO : A decommenter quand le code compilera
//@RestController
//@RequestMapping(value = "/public/bd/login")
//@Transactional
public class LoginBD {

	private static final Logger logger = LoggerFactory.getLogger(LoginBD.class);

	@Autowired
	private AuthenticationProvider authenticationManager;


	/**
	 * methode de connexion d'un utilisateur
	 *
	 * @param request donnÃ©es necessaire a la connexion
	 * @return
	 * @throws RestException
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public UtilisateurDTO login(@RequestBody final LoginRequestDTO request, final HttpServletRequest req) {

		// Controle des params obligatoires
		if (StringUtils.isEmpty(request.getIdentifiant()) || StringUtils.isEmpty(request.getMotDePasse())) {
			throw new BadCredentialsException("User/pwd must not be emtpy");

		}
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getIdentifiant(), request.getMotDePasse()));
		if (authentication == null) {
			throw new BadCredentialsException("User/pwd incorrect");
		}

		final DlabsSpringUser utilisateur = (DlabsSpringUser) authentication.getPrincipal();
		logger.debug("New user logged : " + utilisateur.getUsername());

		// TODO : Ajouter les informations nécessaires au DTO pour retour au front.
		return new UtilisateurDTO();
	}

}
