//
//package br.edu.ifrs.osorio.tads.palomalumi.controller;
//import br.edu.ifrs.osorio.tads.palomalumi.model.Censo;
//import br.edu.ifrs.osorio.tads.palomalumi.repository.CensoRepository;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.catalina.filters.ExpiresFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
////import org.springframework.security.access.prepost.PreAuthorize;
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/censo")
//public class CensoController {
//
//
//    @Autowired
//    private CensoRepository censoRepository;
//
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Censo> getCensoById(@PathVariable Long id) {
//        Optional<Censo> censo = censoRepository.findById(id);
//        return censo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
////    @GetMapping("/formulario")
////    public void formulario(HttpServletResponse response ) throws IOException {
////        response.sendRedirect("/censo-form");
////    }
//
//    @GetMapping // Endpoint: /censos
//    public List<Censo> findAll() {
//        return censoRepository.findAll();
//    }
//
//    @PostMapping // Endpoint: /censos
//    public ResponseEntity<Censo> createCenso(@RequestBody Censo censo) {
//        Censo novoCenso = censoRepository.save(censo);
//        // Boa prática: Retornar 201 Created
//        return ResponseEntity.status(201).body(novoCenso);
//    }
//
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Censo> updateCenso(@PathVariable Long id, @RequestBody Censo censoDetails) {
//        Optional<Censo> censo = censoRepository.findById(id);
//        if (censo.isPresent()) {
//            Censo existingCenso = censo.get();
//
//            // **Usando o método setCenso(Censo) da Entidade**
//            existingCenso.setCenso(censoDetails);
//
//            return ResponseEntity.ok(censoRepository.save(existingCenso));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
// // apenas deleta se for ADM
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCenso(@PathVariable Long id) {
//        if (censoRepository.existsById(id)) {
//            censoRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
////@DeleteMapping("/{id}")
////@PreAuthorize("hasRole('ADMIN')") // Exige que o usuário tenha a função ADMIN
////public ResponseEntity<Void> deleteCenso(@PathVariable Long id) {
////    // ...
////}