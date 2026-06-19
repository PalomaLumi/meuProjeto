package br.edu.ifrs.osorio.tads.palomalumi.controller;

import br.edu.ifrs.osorio.tads.palomalumi.model.Usuario;
import br.edu.ifrs.osorio.tads.palomalumi.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginWebController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(@RequestParam String login,
                             @RequestParam String senha,
                             HttpSession session) {

        Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha);

        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);  // vai direto pra o formulario: como arrumar no html

            return "redirect:/censo/novo";
        }

        return "redirect:/login?erro";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
