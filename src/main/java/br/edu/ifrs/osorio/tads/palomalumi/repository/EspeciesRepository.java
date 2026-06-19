//package br.edu.ifrs.osorio.tads.palomalumi.repository;

//import br.edu.ifrs.osorio.tads.palomalumi.model.Especies;
//import br.edu.ifrs.osorio.tads.palomalumi.model.OperacoesDAO;

import java.util.ArrayList;

//
//@Repository
//public interface EspeciesRepository extends JpaRepository<Especies, Long> {
//    Especies findByNomeCientifico(String nomeCientifico);
//}




//// model/EspeciesDAO.java
//
//
///**
// * DAO para gerenciar operações CRUD de objetos Especies.
// * Inclui uma lista pré-cadastrada de espécies para testes.
// * Futuramente, esta lista pode ser modificada apenas por usuários admin e deve ser comparada com nomes de entrada de especie?
// * * @author lumi
// */
//public class EspeciesRepository implements OperacoesDAO<Especies> {
//
//    private final ArrayList<Especies> especiesCadastradas;
//
//    // Singleton pattern para garantir uma única instância do EspeciesDAO
//    private static EspeciesRepository instance;
//    public static EspeciesRepository getInstance () {
//        if (instance == null) {
//            instance = new EspeciesRepository();
//        }
//        return instance;
//    }
//
//    // Construtor privado que inicializa a lista com algumas espécies pré-cadastradas
//    public EspeciesRepository() {
//        this.especiesCadastradas = new ArrayList<>();
//        // Adicionando algumas espécies para teste
//        // Formato: nomeCientifico, nomePopular, limiteNorte, limiteSul
//        especiesCadastradas.add(new Especies("Sula leucogaster", "Atobá-pardo", 20.0, -30.0));
//        especiesCadastradas.add(new Especies("Puffinus puffinus", "Shearwater-comum", 70.0, -50.0));
//        especiesCadastradas.add(new Especies("Thalassarche melanophris", "Albatroz-de-sobrancelha-negra", 20.0, -60.0));
//        especiesCadastradas.add(new Especies("Macronectes giganteus", "Petrel-gigante", 40.0, -70.0));
//        especiesCadastradas.add(new Especies("Oceanites oceanicus", "Painho-de-wilson", 50.0, -80.0));
//        especiesCadastradas.add(new Especies("Sterna hirundo", "Trinta-réis-comum", 80.0, -50.0));
//        especiesCadastradas.add(new Especies("Hydrobates pelagicus", "Painho-europeu", 60.0, -40.0));
//        especiesCadastradas.add(new Especies("Calonectris borealis", "Cagarra", 40.0, -30.0));
//        especiesCadastradas.add(new Especies("Fregata magnificens", "Fragata", 30.0, 0.0));
//        especiesCadastradas.add(new Especies("Phaethon aethereus", "Rabo-de-palha-de-bico-vermelho", 30.0, -20.0));
//    }
//
//    @Override
//    public void inserir(Especies especie) {
//        especiesCadastradas.add(especie);
//    }
//
//    @Override
//    public boolean pesquisar(Especies especie) {
//        return especiesCadastradas.contains(especie);
//    }
//
//    @Override
//    public boolean excluir(Especies especie) {
//        return especiesCadastradas.remove(especie);
//    }
//
//    @Override
//    public Especies buscar(Object o) {
//        if (o instanceof String) {
//            String nomeCientifico = (String) o;
//            for (Especies e : especiesCadastradas) {
//                if (e.getNomeCientifico().equalsIgnoreCase(nomeCientifico)) {
//                    return e;
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Edita uma espécie existente com novos dados, buscando pelo nome científico.
//     * @param nomeCientifico O nome científico da espécie a ser editada.
//     * @param novosDados O objeto Especies com os novos dados.
//     * @return true se a edição foi bem-sucedida, false caso contrário.
//     */
//    // MANTIVE AQUI , MAS AINDA NAO IMPLEMENTEI USO, SOMENTE PRA ADMIN
//    public boolean editar(String nomeCientifico, Especies novosDados) {
//        Especies especieExistente = buscar(nomeCientifico);
//        if (especieExistente != null) {
//            especieExistente.setNomeCientifico(novosDados.getNomeCientifico());
//            especieExistente.setNomePopular(novosDados.getNomePopular());
//            especieExistente.setLimiteN(novosDados.getLimiteN());
//            especieExistente.setLimiteS(novosDados.getLimiteS());
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * Retorna uma cópia imutável da lista de espécies cadastradas.
//     * Isso permite que outras partes do código leiam a lista sem modificá-la diretamente.
//     * @return Uma lista imutável de Especies.
//     */
//    public ArrayList<Especies> listar() {
//        return new ArrayList<>(this.especiesCadastradas);
//    }
//}
//
