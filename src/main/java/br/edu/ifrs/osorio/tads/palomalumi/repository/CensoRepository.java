package br.edu.ifrs.osorio.tads.palomalumi.repository;

import br.edu.ifrs.osorio.tads.palomalumi.model.Censo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CensoRepository extends JpaRepository<Censo, Long> {

}

