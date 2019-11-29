package sqli.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sqli.challenge.model.Domaine;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long>{

}
