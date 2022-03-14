package fr.univlittoral.dlabs;

import java.security.Principal;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
@Transactional
public class HomePrivateBD {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(final Principal principal) {
		return "Hello " + principal.getName();
	}

}
