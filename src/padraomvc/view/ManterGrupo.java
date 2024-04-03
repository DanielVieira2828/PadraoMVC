/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerGrupo;
import padraomvc.model.bean.Grupo;
import padraomvc.util.ViewBasico;


/**
 *
 * @author ALUNO
 */
public class ManterGrupo implements ViewBasico {
     @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String nomeGrupo = JOptionPane.showInputDialog("Nome Grupo");
        String numGrupo = JOptionPane.showInputDialog("Número Grupo");
        Grupo gruEnt = new Grupo(nomeGrupo,numGrupo);
        ControllerGrupo contgru = new ControllerGrupo();
        Grupo gruSaida = (Grupo) contgru.inserir(gruEnt);
        JOptionPane.showMessageDialog(null,gruSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        String nomeGrupo = JOptionPane.showInputDialog("Nome Grupo");
        String numGrupo = JOptionPane.showInputDialog("Número Grupo");
        Grupo gruEnt = new Grupo(id,nomeGrupo,numGrupo);
        ControllerGrupo contgru = new ControllerGrupo();
        Grupo gruSaida = (Grupo) contgru.alterar(gruEnt);
        JOptionPane.showMessageDialog(null,gruSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Grupo gruEnt = new Grupo(id);
        ControllerGrupo contgru = new ControllerGrupo();
        Grupo gruSaida = (Grupo) contgru.buscar(gruEnt);
        JOptionPane.showMessageDialog(null,gruSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Grupo gruEnt = new Grupo(id);
        ControllerGrupo contgru = new ControllerGrupo();
        Grupo gruSaida = (Grupo) contgru.excluir(gruEnt);
        JOptionPane.showMessageDialog(null,gruSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String nomeGrupo = JOptionPane.showInputDialog("NOME Grupo");
        Grupo gruEnt = new Grupo(nomeGrupo);
        ControllerGrupo contgru = new ControllerGrupo();
        List<Object> listaGrupo = contgru.listar(gruEnt);
        for (Object usuObj : listaGrupo) {
            Grupo gruSaida = (Grupo) usuObj;
            JOptionPane.showMessageDialog(null,gruSaida.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        String nomeGrupo = JOptionPane.showInputDialog("NOME Grupo");
        String numGrupo = JOptionPane.showInputDialog("NÚMERO Grupo");
        Grupo gruEnt = new Grupo(nomeGrupo,numGrupo);
        ControllerGrupo contgru = new ControllerGrupo();
        return contgru.validar(gruEnt);
    }

}
