package br.edu.ifrs.osorio.tads.palomalumi.model;
import jakarta.persistence.*;
import java.io.Serializable;

import java.util.Objects;
/**
 * Representa um usuário do sistema, com login (email), senha e tipo de usuário.
 * * @author lumi
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login; // é o email
    @Column(nullable = false)
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo; //Administrador ou apenas Observador


    public Usuario() {
        // Construtor padrão exigido pelo JPA
    }

    public Usuario(String login, String senha, TipoUsuario tipo) {// este contrutor para caso seja apenas adm, ou apenas usuario comum , e nao seja pesquisaro, observador..
        this.login = login;
        this.senha = senha;
        this.tipo =tipo ;
    }
    // Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTipo(TipoUsuario tipo) {/// /ACHO QUE NÃO DEVERIA SETAR O TIPO
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipo() {
        return this.tipo;
    }


    // Setters
    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login='" + login + '\'' + ", tipo='" + tipo + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getUsername() {
        return this.login;
    }
}

