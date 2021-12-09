package aplicaciones.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.model.Bodega;
import aplicaciones.spring.repo.IBodega;

@Service("bodega")
public class BodegaService {
	@Autowired
	IBodega ibodega;
	public void guardar (Bodega bodega) {
		ibodega.save(bodega);
	}
	public List<Bodega> listar(){
		return ibodega.findAll();
	}
	public Bodega buscar(Integer ruc) {
		return ibodega.findByRuc(ruc);
	}
	public Bodega buscar(Long id) {
		return ibodega.findById(id);
	}
	public List<Bodega> buscar(String region){
		return ibodega.findByRegion(region);
	}
}
