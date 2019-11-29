package sqli.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sqli.challenge.model.Activite;
@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {

}
