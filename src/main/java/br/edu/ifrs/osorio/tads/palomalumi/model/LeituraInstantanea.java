//package br.edu.ifrs.osorio.tads.palomalumi.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name = "leituras_instantaneas")
//public class LeituraInstantanea implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String especie;
//
//    @Column(nullable = false)
//    private int contagem;
//
//    @ManyToOne
//    @JoinColumn(name = "censo_id")
//    private Censo censo;
//
//    public LeituraInstantanea() {
//        // Construtor padrão exigido pelo JPA
//    }
//
//    public LeituraInstantanea(String especie, int contagem) {
//        this.especie = especie;
//        this.contagem = contagem;
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
//    public String getEspecie() {
//        return especie;
//    }
//
//    public void setEspecie(String especie) {
//        this.especie = especie;
//    }
//
//    public int getContagem() {
//        return contagem;
//    }
//
//    public void setContagem(int contagem) {
//        this.contagem = contagem;
//    }
//
//    public Censo getCenso() {
//        return censo;
//    }
//
//    public void setCenso(Censo censo) {
//        this.censo = censo;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LeituraInstantanea that = (LeituraInstantanea) o;
//        return Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "LeituraInstantanea{" +
//                "id=" + id +
//                ", especie=\'" + especie + '\'' +
//                ", contagem=" + contagem +
//                '}';
//    }
//}
//
//
