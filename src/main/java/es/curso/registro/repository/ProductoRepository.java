package es.curso.registro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> findByNombre(String nombre);
	
	List<Producto> findByDescripcion(String descripcion);
	
	List<Producto> findByPrecio(Double precio);
	
	@Query ("select p from Producto p where nombre like %?1% and descripcion like %?2% and "
			+ "(precio = ?3 or ?3 is null)")
	public List<Producto> findByFiltro (String nombre, String descripcion, Double precio);
}
