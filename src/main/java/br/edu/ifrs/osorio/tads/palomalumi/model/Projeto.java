//package br.edu.ifrs.osorio.tads.palomalumi.model;
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name = "projetos")
//public class Projeto implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String nomeProjeto;
//
//    @Column(nullable = false)
//    private String navio;
//
//    @Column(nullable = false)
//    private String anoInicio;
//
//    @Column(nullable = false)
//    private String instituicao;
//
//    public Projeto() {
//        // Construtor padrão exigido pelo JPA
//    }
//
//    public Projeto(String nomeProjeto, String navio, String anoInicio, String instituicao) {
//        this.nomeProjeto = nomeProjeto;
//        this.navio = navio;
//        this.anoInicio = anoInicio;
//        this.instituicao = instituicao;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNomeProjeto() {
//        return nomeProjeto;
//    }
//
//    public void setNomeProjeto(String nomeProjeto) {
//        this.nomeProjeto = nomeProjeto;
//    }
//
//    public String getNavio() {
//        return navio;
//    }
//
//    public void setNavio(String navio) {
//        this.navio = navio;
//    }
//
//    public String getAnoInicio() {
//        return anoInicio;
//    }
//
//    public void setAnoInicio(String anoInicio) {
//        this.anoInicio = anoInicio;
//    }
//
//    public String getInstituicao() {
//        return instituicao;
//    }
//
//    public void setInstituicao(String instituicao) {
//        this.instituicao = instituicao;
//    }
//
//    @Override
//    public String toString() {
//        return "Projeto{" +
//                "id=" + id +
//                ", nomeProjeto='" + nomeProjeto + '\'' +
//                ", navio='" + navio + '\'' +
//                ", anoInicio='" + anoInicio + '\'' +
//                ", instituicao='" + instituicao + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Projeto projeto = (Projeto) o;
//        return Objects.equals(id, projeto.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
