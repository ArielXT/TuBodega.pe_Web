package aplicaciones.spring.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.model.Bodega;
@Repository
public interface IBodega extends JpaRepository<Bodega,Serializable> {
	public abstract Bodega findById(Long id);
	public abstract Bodega findByRuc(Integer ruc);
	public abstract List<Bodega> findByRegion(String region);

}
