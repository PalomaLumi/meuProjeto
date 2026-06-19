package br.edu.ifrs.osorio.tads.palomalumi.controller;

import br.edu.ifrs.osorio.tads.palomalumi.model.Censo;
import br.edu.ifrs.osorio.tads.palomalumi.model.Leitura;
import br.edu.ifrs.osorio.tads.palomalumi.model.Usuario;
import br.edu.ifrs.osorio.tads.palomalumi.repository.CensoRepository;
import br.edu.ifrs.osorio.tads.palomalumi.repository.LeituraRepository;
import br.edu.ifrs.osorio.tads.palomalumi.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
//import org.springframework.security.core.Authentication; // Novo Import
//import org.springframework.security.core.context.SecurityContextHolder;



@Controller
@RequestMapping("/censo") // Prefixo base: /censo
public class CensoWebController {

    @Autowired
    CensoRepository censoRepository;
    @Autowired
    LeituraRepository leituraRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    // --- READ/LISTAGEM (GET /censo) ---
    @GetMapping
    public String listarCenso(Model model) {
        model.addAttribute("censos", censoRepository.findAll());
        return "censo-lista";
    }

    // --- NOVO/EDITAR FORMULÁRIO (GET /censo/novo) ---
    @GetMapping("/novo")
    public String novoCenso(Model model) {
        Censo novoCenso = new Censo();

        // 1. Inicializa o objeto 'observador' para evitar NullPointerException no th:field
        novoCenso.setObservador(new Usuario());

        // 2. Adiciona a lista de usuários para o <select>
        model.addAttribute("censo", novoCenso);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "censo-form";
    }

    // --- SALVAMENTO (POST /censo) ---
    // CensoWebController.java

    // --- SALVAMENTO (POST /censo) ---
    @PostMapping // Mapeia para POST /censo (th:action="@{/censo}" no HTML)
    public String salvar(@ModelAttribute("censo") Censo censo, HttpSession session) {

        // 1. O Observador (Usuario) já está ligado pelo <select> do formulário.
        // Nenhuma lógica extra de sessão ou findById é necessária aqui.

        // 2. Campos automáticos (Data e Hora)
        if (censo.getData() == null) {
            censo.setData(LocalDate.now());
        }
        if (censo.getHora() == null) {
            censo.setHora(LocalTime.now());
        }

        // 3. Garante a bidirecionalidade (CRUCIAL para Leituras)
        // **USANDO A LISTA UNIFICADA: censo.getLeituras()**
        if (censo.getLeituras() != null) {
            censo.getLeituras().forEach(l -> l.setCenso(censo));
        }

        // 4. Salva no banco
        censoRepository.save(censo);

        return "redirect:/censo";
    }
    // --- EDIÇÃO (GET /censo/editar/X) ---
    @GetMapping("/editar/{id}")
    public String editarCenso(@PathVariable Long id, Model model) {
        Censo censo = censoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Censo inválido: " + id));

        model.addAttribute("usuarios", usuarioRepository.findAll()); // essencial para o select
        model.addAttribute("censo", censo);
        return "censo-form";
    }
    // --- EXCLUSÃO (GET /censo/excluir/X) ---
    @GetMapping("/excluir/{id}")
    public String excluirCenso(@PathVariable Long id) {
        censoRepository.deleteById(id);
        return "redirect:/censo";
    }

    // --- LISTAGEM DE LEITURAS POR CENSO (GET /censo/leituras/X) ---
    @GetMapping("/leituras/{censoId}")
    public String listarLeiturasPorCenso(@PathVariable Long censoId, Model model) {
        List<Leitura> leiturasDoCenso = leituraRepository.findByCensoId(censoId);
        model.addAttribute("leituras", leiturasDoCenso);
        model.addAttribute("censoId", censoId);
        return "leitura-lista";
    }

    // --- NOVA LEITURA (GET /censo/nova-leitura) ---
    @GetMapping("/nova-leitura")
    public String novaLeitura(Model model) {
        model.addAttribute("leitura", new Leitura());
        return "leitura-form";
    }
}