package br.edu.ifrs.osorio.tads.palomalumi.service;

import br.edu.ifrs.osorio.tads.palomalumi.model.Censo;
import br.edu.ifrs.osorio.tads.palomalumi.repository.CensoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CensoService {

    @Autowired
    private CensoRepository censoRepository;

    public List<Censo> findAll() {
        return censoRepository.findAll();
    }

    public Optional<Censo> findById(Long id) {
        return censoRepository.findById(id);
    }

    public Censo save(Censo censo) {
        return censoRepository.save(censo);
    }

    public void deleteById(Long id) {
        censoRepository.deleteById(id);
    }
}
