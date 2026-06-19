//package br.edu.ifrs.osorio.tads.palomalumi.model;
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
///**
// * Representa uma espécie de ave marinha com seus nomes popular e científico e limites de distribuição latitudinal
// *  *  @author lumi
// */
//@Entity
//@Table(name = "especies")
//public class Especies implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false, unique = true)
//    private String nomeCientifico;
//    @Column(nullable = false)
//    private String nomePopular;
//    @Column(nullable = false)
//    private double limiteN;
//    @Column(nullable = false)
//    private double limiteS;
//
//    /**
//     * Construtor para criar uma nova instância de Especies.
//     * @param nomeCientifico Nome científico da ave marinha.
//     * @param nomePopular Nome popular da ave marinha.
//     * @param limiteN Limite de latitude norte em que a espécie foi avistada de acordo com dados bibliográficos.
//     * @param limiteS Limite de latitude sul em que a espécie foi avistada de acordo com dados bibliográficos.
//     */
//    public Especies() {
//        // Construtor padrão exigido pelo JPA
//    }
//
//    public Especies(String nomeCientifico, String nomePopular, double limiteN, double limiteS) {
//        this.nomeCientifico = nomeCientifico;
//        this.nomePopular = nomePopular;
//        this.limiteN = limiteN;
//        this.limiteS = limiteS;
//    }
//
//    // Getters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNomeCientifico() {
//        return nomeCientifico;
//    }
//
//    public String getNomePopular() {
//        return nomePopular;
//    }
//
//    public double getLimiteN() {
//        return limiteN;
//    }
//
//    public double getLimiteS() {
//        return limiteS;
//    }
//
//    // Setters
//    public void setNomeCientifico(String nomeCientifico) {
//        this.nomeCientifico = nomeCientifico;
//    }
//
//    public void setNomePopular(String nomePopular) {
//        this.nomePopular = nomePopular;
//    }
//
//    public void setLimiteN(double limiteN) {
//        this.limiteN = limiteN;
//    }
//
//    public void setLimiteS(double limiteS) {
//        this.limiteS = limiteS;
//    }
//
//    @Override
//    public String toString() {
//        return "Espécie [ID=" + id + "]: " + nomeCientifico + " (" + nomePopular + "), Limites Lat.: N " + limiteN + "°, S " + limiteS + "°";
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        final Especies other = (Especies) obj;
//        return Objects.equals(this.id, other.id);
//    }
//}
