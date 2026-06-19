//package br.edu.ifrs.osorio.tads.palomalumi.controller;
//import br.edu.ifrs.osorio.tads.palomalumi.model.Projeto;
//import br.edu.ifrs.osorio.tads.palomalumi.repository.ProjetoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/projetos")
//public class ProjetoController {
//
//    @Autowired
//    private ProjetoRepository projetoRepository;
//
//    @GetMapping
//    public List<Projeto> getAllProjetos() {
//        return projetoRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
//        Optional<Projeto> projeto = projetoRepository.findById(id);
//        return projeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Projeto createProjeto(@RequestBody Projeto projeto) {
//        return projetoRepository.save(projeto);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projetoDetails) {
//        Optional<Projeto> projeto = projetoRepository.findById(id);
//        if (projeto.isPresent()) {
//            Projeto existingProjeto = projeto.get();
//            existingProjeto.setNomeProjeto(projetoDetails.getNomeProjeto());
//            existingProjeto.setNavio(projetoDetails.getNavio());
//            existingProjeto.setAnoInicio(projetoDetails.getAnoInicio());
//            existingProjeto.setInstituicao(projetoDetails.getInstituicao());
//            return ResponseEntity.ok(projetoRepository.save(existingProjeto));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProjeto(@PathVariable Long id) {
//        if (projetoRepository.existsById(id)) {
//            projetoRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
