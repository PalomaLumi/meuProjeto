package br.edu.ifrs.osorio.tads.palomalumi.repository;

import br.edu.ifrs.osorio.tads.palomalumi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
    Usuario findByLoginAndSenha(String login, String senha);
}

