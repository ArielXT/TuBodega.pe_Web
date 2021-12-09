package aplicaciones.spring.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.model.Ruc;

@Repository
public interface IRuc extends JpaRepository<Ruc,Serializable> {
	public abstract Ruc findByRuc(Integer ruc);
	public abstract Ruc findById(Long id);
	public abstract Ruc findByUser(String user);
	

}
