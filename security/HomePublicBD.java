package fr.univlittoral.dlabs;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public/home")
@Transactional
public class HomePublicBD {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {
		return "Hello public";
	}

}
