/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package padraomvc;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import padraomvc.view.ManterGrupo;
import padraomvc.view.ManterUsuario;
import padraomvc.view.ManterUsuarioGrupo;

/**
 *
 * @author LAB 211
 */
public class PadraoMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Agencia \n 3 - Relação";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario mu = new ManterUsuario();
                mu.menu();
                break;
                
            case 2:
                ManterGrupo mu2 = new ManterGrupo();
                mu2.menu();
                break;
                
            case 3:
                ManterUsuarioGrupo mu3 = new ManterUsuarioGrupo();
                mu3.menu();
                break;
            default:
                System.out.println("Opção inválido");
        }
    }
    
}
