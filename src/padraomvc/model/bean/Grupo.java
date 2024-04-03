/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.bean;

import java.io.Serializable;

/**
 *
 * @author ALUNO
 */
public class Grupo implements Serializable{
    
    private int id;
    private String nomeGrupo;
    private String numGrupo;

    public Grupo(int id) {
        this.id = id;
    }
    
    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public Grupo(String nomeGrupo, String numGrupo) {
        this.nomeGrupo = nomeGrupo;
        this.numGrupo = numGrupo;
    }

    public Grupo(int id, String nomeGrupo, String numGrupo) {
        this.id = id;
        this.nomeGrupo = nomeGrupo;
        this.numGrupo = numGrupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getNumGrupo() {
        return numGrupo;
    }

    public void setNumGrupo(String numGrupo) {
        this.numGrupo = numGrupo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", nomeGrupo=" + nomeGrupo + ", numGrupo=" + numGrupo + '}';
    }
    
    
}
