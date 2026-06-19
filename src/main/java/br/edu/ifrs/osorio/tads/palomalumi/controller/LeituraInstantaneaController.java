//package br.edu.ifrs.osorio.tads.palomalumi.controller;
//import br.edu.ifrs.osorio.tads.palomalumi.model.LeituraInstantanea;
//import br.edu.ifrs.osorio.tads.palomalumi.repository.LeituraInstantaneaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/leituras-instantaneas")
//public class LeituraInstantaneaController {
//
//    @Autowired
//    private LeituraInstantaneaRepository leituraInstantaneaRepository;
//
//    @GetMapping
//    public List<LeituraInstantanea> getAllLeiturasInstantaneas() {
//        return leituraInstantaneaRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<LeituraInstantanea> getLeituraInstantaneaById(@PathVariable Long id) {
//        Optional<LeituraInstantanea> leituraInstantanea = leituraInstantaneaRepository.findById(id);
//        return leituraInstantanea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public LeituraInstantanea createLeituraInstantanea(@RequestBody LeituraInstantanea leituraInstantanea) {
//        return leituraInstantaneaRepository.save(leituraInstantanea);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<LeituraInstantanea> updateLeituraInstantanea(@PathVariable Long id, @RequestBody LeituraInstantanea leituraInstantaneaDetails) {
//        Optional<LeituraInstantanea> leituraInstantanea = leituraInstantaneaRepository.findById(id);
//        if (leituraInstantanea.isPresent()) {
//            LeituraInstantanea existingLeituraInstantanea = leituraInstantanea.get();
//            existingLeituraInstantanea.setLatitude(leituraInstantaneaDetails.getLatitude());
//            existingLeituraInstantanea.setLongitude(leituraInstantaneaDetails.getLongitude());
//            existingLeituraInstantanea.setDistancia(leituraInstantaneaDetails.getDistancia());
//            existingLeituraInstantanea.setDirecao(leituraInstantaneaDetails.getDirecao());
//            existingLeituraInstantanea.setCenso(leituraInstantaneaDetails.getCenso());
//            return ResponseEntity.ok(leituraInstantaneaRepository.save(existingLeituraInstantanea));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteLeituraInstantanea(@PathVariable Long id) {
//        if (leituraInstantaneaRepository.existsById(id)) {
//            leituraInstantaneaRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
//
