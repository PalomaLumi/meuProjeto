package br.edu.ifrs.osorio.tads.palomalumi.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import br.edu.ifrs.osorio.tads.palomalumi.model.TipoUsuario;

/**
 *Enum com os tipo de usuarios do sistema *
 * ADMIN é usuario master que pode editar e excluir dados dos censos: futuro, autoriza cadastras espécies ...
 * COMUM apenas observador, não acessa alteraçoes
 * @author lumi
 */
public enum TipoUsuario {
    ADMIN, COMUM
}
