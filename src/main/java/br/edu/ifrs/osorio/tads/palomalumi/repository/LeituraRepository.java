package br.edu.ifrs.osorio.tads.palomalumi.repository;

import br.edu.ifrs.osorio.tads.palomalumi.model.Leitura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeituraRepository extends JpaRepository<Leitura, Long> {
    List<Leitura> findByCensoId(Long censoId);
}

