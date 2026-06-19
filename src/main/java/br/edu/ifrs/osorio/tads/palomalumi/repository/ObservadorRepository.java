package br.edu.ifrs.osorio.tads.palomalumi.repository;
import br.edu.ifrs.osorio.tads.palomalumi.model.Observador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ObservadorRepository extends JpaRepository<Observador, Long> {
}
