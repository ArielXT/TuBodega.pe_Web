package aplicaciones.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import aplicaciones.spring.model.Ruc;
import aplicaciones.spring.service.RucService;

@Controller
@RequestMapping("/ruc")
@SessionAttributes("ruc")
public class RucController {
	@Autowired
	@Qualifier("ruc")
	RucService rucService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Ruc> rucs = rucService.listar();
		model.addAttribute("rucs",rucs);
		model.addAttribute("titulo","Lista de rucs");
		return "rucListado";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Ruc ruc = new Ruc();
		model.put("ruc",ruc);
		model.put("btn", "Registrar");
		return "rucForm";
	}
	@RequestMapping("/formulario")
	public String formulario (Model model) {
		model.addAttribute("ruc", new Ruc());
		return "login";
	}
	
	@GetMapping("/busqueda")
	public String findByUser (@RequestParam String user,Model model,@ModelAttribute("ruc") Ruc ruc) {
		List<Ruc> listar = rucService.listar();
		model.addAttribute("listar",listar);
		model.addAttribute("listar", rucService.buscar(user));
		return "rucListar";
	}
	
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("ruc",rucService.buscar(id));
		model.addAttribute("btn","Actualiza ruc");
		return "rucForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Ruc ruc,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			ruc = new Ruc();
			model.addAttribute("ruc",ruc);
			model.addAttribute("btn","Registrar");
			return "rucForm";
		}else {
			rucService.guardar(ruc);
		return "redirect:/verificacion";
		}
	}
	
	
}


