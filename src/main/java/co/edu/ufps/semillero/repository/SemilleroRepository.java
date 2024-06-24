package co.edu.ufps.semillero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ufps.semillero.model.Semillero;

public interface SemilleroRepository extends JpaRepository<Semillero, Integer>  {

}