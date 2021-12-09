package aplicaciones.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.model.Ruc;
import aplicaciones.spring.repo.IRuc;

@Service("ruc")
public class RucService {
	@Autowired
	IRuc iruc;
	public void guardar(Ruc ruc) {
		iruc.save(ruc);
		
	}
	public List<Ruc> listar(){
		return iruc.findAll();
		}
	public Ruc buscar(String user) {
		return iruc.findByUser(user);
	}
	public Ruc buscar(Integer ruc) {
		return iruc.findByRuc(ruc);
	}
	public Ruc buscar(Long id) {
		return iruc.findById(id);
	}
}
