//package br.edu.ifrs.osorio.tads.palomalumi.controller;
//import br.edu.ifrs.osorio.tads.palomalumi.model.Especies;
//import br.edu.ifrs.osorio.tads.palomalumi.repository.EspeciesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/especies")
//public class EspeciesController {
//
//    @Autowired
//    private EspeciesRepository especiesRepository;
//
//    @GetMapping
//    public List<Especies> getAllEspecies() {
//        return especiesRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Especies> getEspeciesById(@PathVariable Long id) {
//        Optional<Especies> especie = especiesRepository.findById(id);
//        return especie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Especies createEspecies(@RequestBody Especies especie) {
//        return especiesRepository.save(especie);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Especies> updateEspecies(@PathVariable Long id, @RequestBody Especies especiesDetails) {
//        Optional<Especies> especie = especiesRepository.findById(id);
//        if (especie.isPresent()) {
//            Especies existingEspecies = especie.get();
//            existingEspecies.setNomeCientifico(especiesDetails.getNomeCientifico());
//            existingEspecies.setNomePopular(especiesDetails.getNomePopular());
//            existingEspecies.setLimiteN(especiesDetails.getLimiteN());
//            existingEspecies.setLimiteS(especiesDetails.getLimiteS());
//            return ResponseEntity.ok(especiesRepository.save(existingEspecies));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEspecies(@PathVariable Long id) {
//        if (especiesRepository.existsById(id)) {
//            especiesRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
