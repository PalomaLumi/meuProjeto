package br.edu.ifrs.osorio.tads.palomalumi.model;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "observadores")
public class Observador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExObservador experiencia;

    @Column(nullable = false)
    private String instituicao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Observador() {
        // Construtor padrão exigido pelo JPA
    }

    public Observador(String nome, String instituicao, ExObservador experiencia, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.experiencia = experiencia;
        this.instituicao = instituicao;
    }

    public Observador(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.experiencia = ExObservador.SEM_EXPERIENCIA;
        this.instituicao = "Nao informada"; // Valor padrão
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ExObservador getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(ExObservador experiencia) {
        this.experiencia = experiencia;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setObservador(Observador novosDados) {
        this.nome = novosDados.getNome();
        this.experiencia = novosDados.getExperiencia();
        this.instituicao = novosDados.getInstituicao();
        if (novosDados.getUsuario() != null) {
            this.usuario = novosDados.getUsuario();
        }
    }

    @Override
    public String toString() {
        return "Observador{" +
                "id=" + id +
                ", nome='" + nome + "'" +
                ", experiencia=" + experiencia +
                ", instituicao='" + instituicao + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observador that = (Observador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
