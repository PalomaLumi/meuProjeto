//package br.edu.ifrs.osorio.tads.palomalumi.model;
//
// model/OperacoesDAO.java
//package model;
//
//import java.util.ArrayList;
//
///**
// * Interface genérica para operações de Data Access Object (DAO).
// * Define as operações básicas de CRUD (Create, Read, Update, Delete).
// * @author 2024020183
// * @param <T> O tipo de objeto que o DAO irá gerenciar.
// */
//public interface OperacoesDAO <T> {
//
//    /**
//     * Insere um novo objeto no repositório de dados.
//     * @param t O objeto a ser inserido.
//     */
//    public void inserir (T t);
//
//    /**
//     * Exclui um objeto do repositório de dados.
//     * @param t O objeto a ser excluído.
//     * @return true se o objeto foi excluído com sucesso, false caso contrário.
//     */
//    public boolean excluir (T t);
//
//    /**
//     * Pesquisa um objeto no repositório de dados.
//     * @param t O objeto a ser pesquisado.
//     * @return true se o objeto foi encontrado, false caso contrário.
//     */
//    public boolean pesquisar (T t);
//
//    /**
//     * Busca um objeto no repositório de dados com base em um critério.
//     * @param o O critério de busca (pode ser um ID, nome, etc.).
//     * @return O objeto encontrado, ou null se não for encontrado.
//     */
//    public T buscar (Object o);
//
//    //ArrayList<T> lista();
//}
