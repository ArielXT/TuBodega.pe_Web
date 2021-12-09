package aplicaciones.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.model.Usuario;
import aplicaciones.spring.repo.IUsuario;

@Service("usuario")
public class UsuarioService {
	@Autowired
	IUsuario iusuario;
	public void guardar(Usuario usuario) {
		iusuario.save(usuario);
	}
	
	public List<Usuario> listar(){
		return iusuario.findAll();
	}
	
}

