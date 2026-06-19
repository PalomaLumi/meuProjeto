package br.edu.ifrs.osorio.tads.palomalumi.controller;
import br.edu.ifrs.osorio.tads.palomalumi.model.ExObservador;
import br.edu.ifrs.osorio.tads.palomalumi.model.Observador;
import br.edu.ifrs.osorio.tads.palomalumi.model.Usuario;
import br.edu.ifrs.osorio.tads.palomalumi.repository.ObservadorRepository;
import br.edu.ifrs.osorio.tads.palomalumi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/observadores")
public class ObservadorController {

    @Autowired
    private ObservadorRepository observadorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", observadorRepository.findAll());
        return "observador-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("observador", new Observador());
        model.addAttribute("experiencias", ExObservador.values());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "observador-form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Observador obs = observadorRepository.findById(id).orElseThrow();
        model.addAttribute("observador", obs);
        model.addAttribute("experiencias", ExObservador.values());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "observador-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Observador observador) {

        // Recupera o usuário selecionado
        if (observador.getUsuario() != null && observador.getUsuario().getId() != null) {
            Usuario u = usuarioRepository.findById(observador.getUsuario().getId()).orElse(null);
            observador.setUsuario(u);
        }

        observadorRepository.save(observador);
        return "redirect:/observadores";
    }
}

