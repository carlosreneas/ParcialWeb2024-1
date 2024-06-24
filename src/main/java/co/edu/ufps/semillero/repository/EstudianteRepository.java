package co.edu.ufps.semillero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ufps.semillero.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>  {

}
