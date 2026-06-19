//package br.edu.ifrs.osorio.tads.palomalumi.controller;
//
//import br.edu.ifrs.osorio.tads.palomalumi.model.Censo;
//import br.edu.ifrs.osorio.tads.palomalumi.model.Leitura;
//import br.edu.ifrs.osorio.tads.palomalumi.repository.CensoRepository;
//import br.edu.ifrs.osorio.tads.palomalumi.repository.LeituraRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping ("/form")
//public class FormController {
//
//    @Autowired
//    CensoRepository censoRepository;
//    @Autowired
//    LeituraRepository leituraRepository;
//
//   @GetMapping("/cadastrar")
//    public String formulario (Model model) {
//       model.addAttribute("censos", new Censo());
//        return "/censo-form";
//
//    }
//    @GetMapping("/listar")
//    public String listarCenso(Model model) {
//        model.addAttribute("censos", censoRepository.findAll());
//        return "/censo-lista";
//    }
//
//
//    @GetMapping("/leituras")
//    public String listarLeitura(Model model) {
//        List<Leitura> leituras = leituraRepository.findAll();
//        model.addAttribute("leituras", leituraRepository.findAll());
//        return "/leitura-lista";
//    }
//
//
//
//}