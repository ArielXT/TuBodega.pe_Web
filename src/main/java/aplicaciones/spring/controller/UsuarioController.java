package aplicaciones.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import aplicaciones.spring.model.Usuario;
import aplicaciones.spring.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
@SessionAttributes("usuario")
public class UsuarioController {
	@Autowired
	@Qualifier("usuario")
	UsuarioService usuarioservice;
	
	
	@RequestMapping("/form")
	public String formulario(Map<String, Object> model) {
		Usuario usuario=new Usuario();
		
		model.put("usuario", usuario);
		
		model.put("btn","Siguiente");
		return "userForm";
	}
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Usuario usuario,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			usuario= new Usuario();
			model.addAttribute("btn","Siguiente");
			return "userForm";
		}else {
		usuarioservice.guardar(usuario);
		return "redirect:/ruc/form";
		
		}
	}
}
