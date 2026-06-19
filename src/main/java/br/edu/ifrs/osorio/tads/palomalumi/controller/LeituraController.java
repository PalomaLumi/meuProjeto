//package br.edu.ifrs.osorio.tads.palomalumi.controller;
//import br.edu.ifrs.osorio.tads.palomalumi.model.Leitura;
//import br.edu.ifrs.osorio.tads.palomalumi.repository.LeituraRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/leituras")
//public class LeituraController {
//
//    @Autowired
//    private LeituraRepository leituraRepository;
//
//    @GetMapping("/listar")
//    public List<Leitura> getAllLeituras() {
//        return leituraRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Leitura> getLeituraById(@PathVariable Long id) {
//        Optional<Leitura> leitura = leituraRepository.findById(id);
//        return leitura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/salvar")
//    public Leitura createLeitura(@RequestBody Leitura leitura) {
//        return leituraRepository.save(leitura);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Leitura> updateLeitura(@PathVariable Long id, @RequestBody Leitura leituraDetails) {
//        Optional<Leitura> leitura = leituraRepository.findById(id);
//        if (leitura.isPresent()) {
//            Leitura existingLeitura = leitura.get();
//            existingLeitura.setEspecie(leituraDetails.getEspecie());
////            existingLeitura.setQtd(leituraDetails.getQtd());
////            existingLeitura.setDirecao(leituraDetails.getDirecao());
////            existingLeitura.setObservador(leituraDetails.getObservador());
//            existingLeitura.setCenso(leituraDetails.getCenso());
//            return ResponseEntity.ok(leituraRepository.save(existingLeitura));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteLeitura(@PathVariable Long id) {
//        if (leituraRepository.existsById(id)) {
//            leituraRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
