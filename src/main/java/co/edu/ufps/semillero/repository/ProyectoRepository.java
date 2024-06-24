package co.edu.ufps.semillero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ufps.semillero.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>  {

}
