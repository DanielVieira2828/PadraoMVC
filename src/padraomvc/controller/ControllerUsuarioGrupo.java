/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Grupo;
import padraomvc.model.bean.Usuario;
import padraomvc.model.bean.UsuarioGrupo;
import padraomvc.model.dao.DaoUsuarioGrupo;
import padraomvc.util.ControllerBasico;

/**
 *
 * @author ALUNO
 */
public class ControllerUsuarioGrupo implements ControllerBasico{
    
    DaoUsuarioGrupo dao;
    ControllerUsuario contUsu;
    ControllerGrupo contGru;
    
    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGrupo();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGrupo();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGrupo();
        UsuarioGrupo objSaida = (UsuarioGrupo) dao.buscar(obj);
        Object usu = new Usuario(objSaida.getIdU());
        Object gru = new Grupo(objSaida.getIdG());
        contUsu = new ControllerUsuario();
        contGru = new ControllerGrupo();
        objSaida.setUsu(contUsu.buscar(usu));
        objSaida.setGru(contGru.buscar(gru));
        return objSaida;
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGrupo();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGrupo();
        List<Object> listaAux = dao.listar(obj);
        List<Object> lista = new ArrayList<>();
        for (Object objlista : listaAux) {
            lista.add(buscar(objlista));
        }
        return lista;
     }
}
