/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import padraomvc.util.DaoBasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Grupo;
import padraomvc.util.ConexaoDb;

/**
 *
 * @author ALUNO
 */
public class DaoGrupo implements DaoBasico {
        private final Connection c;
    
    public DaoGrupo() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

        public Grupo validar(Grupo gruEnt) throws SQLException {
        
        String sql = "select * from grupos WHERE nomeGrupo = ? AND numGrupo = ?";
      
        PreparedStatement stmt = this.c.prepareStatement(sql);
       
        stmt.setString(1,gruEnt.getNomeGrupo());
        stmt.setString(2,gruEnt.getNumGrupo());
        
        ResultSet rs = stmt.executeQuery();
        
        Grupo gruSaida = null;
        while (rs.next()) {      
          
            gruSaida = new Grupo(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
          
        }
        stmt.close();
        System.out.println(gruSaida);
        return gruSaida; 
    }

    
    @Override
    public Object inserir(Object obj) throws SQLException {
        Grupo gruEnt = (Grupo) obj;
        String sql = "insert into grupos" + " (nomeGrupo, numGrupo)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,gruEnt.getNomeGrupo());
        stmt.setString(2,gruEnt.getNumGrupo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            gruEnt.setId(id);
        }
        stmt.close();
        return gruEnt;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        Grupo gruEnt = (Grupo) obj;
        String sql = "UPDATE grupos SET nomeGrupo = ?, numGrupo = ? WHERE id = ?";
       
        PreparedStatement stmt = c.prepareStatement(sql);
       
        stmt.setString(1,gruEnt.getNomeGrupo());
        stmt.setString(2,gruEnt.getNumGrupo());
        stmt.setInt(5,gruEnt.getId());
       
        stmt.execute();
        stmt.close();
        return gruEnt;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        Grupo gruEnt = (Grupo) obj;
        String sql = "delete from grupos WHERE id = ?";
       
        PreparedStatement stmt = c.prepareStatement(sql);
       
        stmt.setInt(1,gruEnt.getId());
       
        stmt.execute();
        stmt.close();
        c.close();
        return gruEnt;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        Grupo gruEnt = (Grupo) obj;
        String sql = "select * from grupos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,gruEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Grupo gruSaida = null;
            while (rs.next()) {      
          
                gruSaida = new Grupo(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
          
            }
            stmt.close();
        return gruSaida;
    }
    
    
    @Override
    public List<Object> listar(Object obj) throws SQLException  {
        Grupo gruEnt = (Grupo) obj;
       
        List<Object> grus = new ArrayList<>();
        
        String sql = "select * from grupos where nomeGrupo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
       
        stmt.setString(1,"%" + gruEnt.getNomeGrupo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
           
            Grupo gru = new Grupo(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            );
            // adiciona o gru à lista de grus
            grus.add(gru);
        }
        
        rs.close();
        stmt.close();
        return grus;
    }
}
