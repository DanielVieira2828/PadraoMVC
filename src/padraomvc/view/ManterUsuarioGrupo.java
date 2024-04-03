/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerUsuarioGrupo;
import padraomvc.model.bean.UsuarioGrupo;
import padraomvc.util.ViewBasico;

/**
 *
 * @author ALUNO
 */
public class ManterUsuarioGrupo implements ViewBasico{
     @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 -> inserir();
            case 2 -> alterar();
            case 3 -> buscar();
            case 4 -> excluir();
            case 5 -> listar();
            default -> System.out.println("Opcao inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idA = Integer.parseInt(JOptionPane.showInputDialog("IDG"));
        String relacao = JOptionPane.showInputDialog("Relação");
        UsuarioGrupo usuEnt = new UsuarioGrupo(idU, idA, relacao);
        ControllerUsuarioGrupo contUsu = new ControllerUsuarioGrupo();
        UsuarioGrupo usuSaida = (UsuarioGrupo) contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idA = Integer.parseInt(JOptionPane.showInputDialog("IDG"));
        String relacao = JOptionPane.showInputDialog("Relação");
        UsuarioGrupo usuEnt = new UsuarioGrupo(id,idU, idA, relacao);
        ControllerUsuarioGrupo contUsu = new ControllerUsuarioGrupo();
        UsuarioGrupo usuSaida = (UsuarioGrupo) contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioGrupo usuEnt = new UsuarioGrupo(id);
        ControllerUsuarioGrupo contUsu = new ControllerUsuarioGrupo();
        UsuarioGrupo usuSaida = (UsuarioGrupo) contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        JOptionPane.showMessageDialog(null,usuSaida.getUsu().toString());
        JOptionPane.showMessageDialog(null,usuSaida.getGru().toString());

    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioGrupo usuEnt = new UsuarioGrupo(id);
        ControllerUsuarioGrupo contUsu = new ControllerUsuarioGrupo();
        UsuarioGrupo usuSaida = (UsuarioGrupo) contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String relacao = JOptionPane.showInputDialog("Relação");
        UsuarioGrupo usuEnt = new UsuarioGrupo(relacao);
        ControllerUsuarioGrupo contUsu = new ControllerUsuarioGrupo();
        List<Object> listaUsuario = contUsu.listar(usuEnt);
        for (Object usuObj : listaUsuario) {
            UsuarioGrupo usuSaida = (UsuarioGrupo) usuObj;
            JOptionPane.showMessageDialog(null,usuSaida.toString());
            JOptionPane.showMessageDialog(null,usuSaida.getUsu().toString());
            JOptionPane.showMessageDialog(null,usuSaida.getGru().toString());
        }
    }
}
