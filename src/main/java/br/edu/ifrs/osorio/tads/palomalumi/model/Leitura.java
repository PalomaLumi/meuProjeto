package br.edu.ifrs.osorio.tads.palomalumi.model;
/**
 * Esta classe esta dentro de censo, e somente  pode ser manipulada dentro do censo .
 * @author lumi
 */

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "leituras")
public class Leitura  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private int contagem;

    // CAMPO OBRIGATÓRIO PARA DIFERENCIAR (SEGUIDORA / CONTINUO)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoLeitura tipo;

    @ManyToOne
    @JoinColumn(name="censo_id", nullable=false)
    private Censo censo;

    public Leitura() {}

    public Leitura(String especie, int contagem, TipoLeitura tipo) {
        this.especie = especie;
        this.contagem = contagem;
        this.tipo = tipo;
    }

    // -------------------- GETTERS E SETTERS -----------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getContagem() {
        return contagem;
    }

    public void setContagem(int contagem) {
        this.contagem = contagem;
    }

    public TipoLeitura getTipo() {
        return tipo;
    }

    public void setTipo(TipoLeitura tipo) {
        this.tipo = tipo;
    }

    public Censo getCenso() {
        return censo;
    }

    public void setCenso(Censo censo) {
        this.censo = censo;
    }

    // -------------------- EQUALS E HASHCODE -----------------------

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Leitura other = (Leitura) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
