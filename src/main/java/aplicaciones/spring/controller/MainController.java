package aplicaciones.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller

public class MainController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/verificacion")
	public String validacion() {
		return "verificacion";
	}
	
	
	@GetMapping("/crud")
	public String crud() {
		return "crud";
	}

	@GetMapping("/map")
	public String map() {
		return "map";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}