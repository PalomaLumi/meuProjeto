package br.edu.ifrs.osorio.tads.palomalumi.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

/**
 *Esta classe encapsula aos dados coletados  nos censos realizados a cada uma hora durante a navegação
 * Sao tomados dados oceanograficose parametros de navegação, e após são realizados os censos para identificação e contagem das aves.
 * NAO IMPLEMENTEI , MAS DEPOIS PENSEI MELHOR E DADOS DE NAVEGAÇÃO DEVEM SER UMA CLASSE SEPARADA
 * @author lumi
 */

@Entity
@Table(name = "censos")
public class Censo implements Serializable {
    /**
     * Contador estático para garantir que cada novo censo receba um código único.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false)
    private LocalTime hora;
    @Column(nullable = false)
    private double direcaoNavegacao;
    @Column(nullable = false)
    private double velocidadeNavegacao;
    @Column(nullable = false)
    private double velocidadeVento;
    @Column(nullable = false)
    private double direcaoVento;
    @Column(nullable = false)
    private double pressao;
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;
    @Column(nullable = false)
    private double profundidade;


    @OneToMany(mappedBy = "censo", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Leitura> leituras = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }
//
//    @OneToMany(mappedBy = "censo", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Leitura> leiturasSeguidoras = new ArrayList<>();
//    @OneToMany(mappedBy = "censo", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Leitura> leiturasContinuo = new ArrayList<>();
////    @OneToMany(mappedBy = "censo", cascade = CascadeType.ALL, orphanRemoval = true)
////    private List<LeituraInstantanea> leiturasInstantaneas = new ArrayList<>();
//

   @ManyToOne
   @JoinColumn(name = "observador_id", nullable = false)
   private Usuario observador;
//    ///  COMO INCLUIR O PROJETO ?
   // @ManyToOne
   // @JoinColumn(name = "projeto_id", nullable = false) // Assumindo que todo censo pertence a um projeto
   // private Projeto projeto;


    /**
     * Construtor principal para criar um objeto Censo completo.
     * O código do censo é gerado automaticamente de forma sequencial.     *
     * @param direcaoNavegacao A direção da navegação em graus (0-360°).
     * @param velocidadeNavegacao A velocidade da embarcação em nós.
     * @param velocidadeVento A velocidade do vento em nós.
     * @param direcaoVento A direção de origem do vento em graus(0-360°).
     * @param pressao A pressão atmosférica.
     * @param latitude A coordenada de latitude (ex: -31.4567).
     * @param longitude A coordenada de longitude (ex: -41.1234).
     * @param profundidade A profundidade local em metros.
     * @param observador O objeto Usuario que representa o observador logado.
     * @param leiturasSeguidoras Uma lista de leituras de aves seguidoras.
     * @param leiturasContinuo Uma lista de leituras do censo contínuo.
     //* @param leiturasInstantaneas Uma lista de listas, onde cada lista interna representa uma das 10 sessões de leitura instantânea.
     */
    public Censo(double direcaoNavegacao, double velocidadeNavegacao, double velocidadeVento,
                 double direcaoVento, double pressao, double latitude, double longitude,
                 double profundidade, Usuario observador, List<Leitura> leituras) {

        this.data = LocalDate.now();
        this.hora = LocalTime.now();
        this.direcaoNavegacao = direcaoNavegacao;
        this.velocidadeNavegacao = velocidadeNavegacao;
        this.velocidadeVento = velocidadeVento;
        this.direcaoVento = direcaoVento;
        this.pressao = pressao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.profundidade = profundidade;
        this.observador = observador;

        if (leituras != null) {
            leituras.forEach(l -> l.setCenso(this));
            this.leituras.addAll(leituras);
        }
    }


    // Getters---embora nao usado neste momento, acredito que é util ter apenas o getters destes dados .... futuramente para busca ?
    /**
     * Retorna o código único deste censo.
     * @return o código do censo.
     */
    public Censo() {
        // Construtor padrão exigido pelo JPA
    }

    public Long getId() {
        return id;
    }

    /**
     * Retorna o observador que registrou este censo.
     * @return o objeto Usuario do observador.
     */
    public Usuario getObservador() {
        return observador;
    }

    /**
     * Retorna a data que o censo foi realizado.
     * @return a data da orealização do censo
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Retorna horario que o censo foi realizado.
     * @return a hora da realização do censo
     */
    public LocalTime getHora() {
        return hora;
    }

    public double getDirecaoNavegacao() {
        return direcaoNavegacao;
    }

    public double getVelocidadeNavegacao() {
        return velocidadeNavegacao;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public double getDirecaoVento() {
        return direcaoVento;
    }

    public double getPressao() {
        return pressao;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getProfundidade() {
        return profundidade;
    }



    //SETERS, mantive, mas nao tem tbm aplicação neste sistema, no caso poderia futuramente ter aplicaçãoo para ajustes de dados pelo ADMIN, em caso de anotaçoes equivocadas???
    public void setDirecaoNavegacao(double direcaoNavegacao) {
        this.direcaoNavegacao = direcaoNavegacao;
    }

    public void setVelocidadeNavegacao(double velocidadeNavegacao) {
        this.velocidadeNavegacao = velocidadeNavegacao;
    }

    public void setVelocidadeVento(double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public void setDirecaoVento(double direcaoVento) {
        this.direcaoVento = direcaoVento;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    /**
     * Atualiza os dados deste Censo com base nas informações de outro objeto Censo.
     * Metodo pra edição pois preserva o código, data,hora e
     * o status e o observador originais.     *
     * @param novosDados O objeto Censo contendo os novos dados a serem copiados.
     */
    public void setCenso(Censo novos) {

        this.direcaoNavegacao = novos.direcaoNavegacao;
        this.velocidadeNavegacao = novos.velocidadeNavegacao;
        this.velocidadeVento = novos.velocidadeVento;
        this.direcaoVento = novos.direcaoVento;
        this.pressao = novos.pressao;
        this.latitude = novos.latitude;
        this.longitude = novos.longitude;
        this.profundidade = novos.profundidade;

        this.leituras.clear();
        novos.leituras.forEach(l -> l.setCenso(this));
        this.leituras.addAll(novos.leituras);
    }

    /**
     * Retorna uma representação em String completa e formatada do objeto Censo
     *
     *  @return Uma String multi-linha com todos os detalhes do censo.
     */


    @Override
    public int hashCode() {
        return Objects.hash(id);    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Censo other = (Censo) obj;
        if (this.id == null || other.id == null) return false;
        return this.id.equals(other.id);
    }

    public void setObservador(Usuario observador) {
        this.observador = observador;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setUsuario(Usuario usuarioLogado) {
        this.observador = usuarioLogado;  // O usuário logado É o observador
    }

    // NOVO MÉTODO A SER ADICIONADO NO BLOCO DE GETTERS:

    /**
     * Retorna a lista unificada de leituras deste censo.
     * @return a lista de leituras.
     */
    public List<Leitura> getLeituras() {
        return leituras;
    }


}