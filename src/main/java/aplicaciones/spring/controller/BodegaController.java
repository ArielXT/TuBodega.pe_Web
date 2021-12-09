package aplicaciones.spring.controller;
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

import aplicaciones.spring.model.Bodega;
import aplicaciones.spring.service.BodegaService;
@Controller
@RequestMapping("/bodegas")
@SessionAttributes("bodega")

public class BodegaController {
	@Autowired
	@Qualifier("bodega")
	BodegaService bodegaService;
	

	@RequestMapping("/form")
	public String formulario (Model model) {
		Bodega bodega = new Bodega();
		model.addAttribute("bodega", bodega);
		model.addAttribute("btn", "Crear tienda");
		return "bodegaForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Bodega bodega,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			bodega = new Bodega();
			model.addAttribute("bodega",bodega);
			model.addAttribute("btn","Crear ");
			return "bodegaForm";
		}else {
			bodegaService.guardar(bodega);
		return "guardar";
		}
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("bodega",bodegaService.buscar(id));
		
		model.addAttribute("btn","Actualiza Registro");
		return "bodegaForm";
	}
	@GetMapping("/usuario")
	public String rucform(Model model) {
		model.addAttribute("bodega", new Bodega());
		return "usuarioTienda";
	}
	@RequestMapping("/listar")
	public String listar(@RequestParam Integer ruc,Model model,@ModelAttribute("bodega") Bodega bodega) {
		model.addAttribute("bodegas",bodegaService.buscar(ruc));
		return "bodegaListar";
	}
	
	
	@GetMapping("/busqueda")
	public String tiendaForm(Model model) {
		model.addAttribute("bodega", new Bodega());
		return "map";
	}
	@GetMapping("/tiendas")
	public String buscarRegion(@RequestParam String region,Model model,@ModelAttribute("bodega") Bodega bodega) {
		model.addAttribute("bodegaPorRegion", bodegaService.buscar(region));
		return "bodegas";
	}
	
}
