/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.bean.Grupo;
import padraomvc.model.dao.DaoGrupo;
import padraomvc.util.ControllerBasico;

/**
 *
 * @author ALUNO
 */
public class ControllerGrupo implements ControllerBasico {
    DaoGrupo daoGru;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        daoGru = new DaoGrupo();
        Grupo usuSaida = (Grupo) daoGru.inserir(obj);
        return usuSaida;
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        daoGru = new DaoGrupo();
        return daoGru.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        daoGru = new DaoGrupo();
        return daoGru.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        daoGru = new DaoGrupo();
        return daoGru.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        daoGru = new DaoGrupo();
        return daoGru.listar(obj);
     }
    

    public boolean validar(Grupo gruEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        daoGru = new DaoGrupo();
        Grupo usuSaida = daoGru.validar(gruEnt);
        if(usuSaida != null) {
            retorno = true;
        }
        return retorno;
    }
}
