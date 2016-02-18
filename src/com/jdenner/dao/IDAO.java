package com.jdenner.dao;

import java.util.ArrayList;

/**
 * Interface para classes de acesso a dados
 *
 * @author Juliano
 */
public interface IDAO<Tipo> {

    public void inserir(Tipo objeto) throws Exception;

    public void alterar(Tipo objeto) throws Exception;

    public void excluir(Tipo objeto) throws Exception;

    public ArrayList<Tipo> listarTodos() throws Exception;

    public Tipo recuperar(int codigo) throws Exception;
}
