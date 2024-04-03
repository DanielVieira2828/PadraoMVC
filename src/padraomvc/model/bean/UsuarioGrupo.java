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
public class UsuarioGrupo implements Serializable{
    
    
    private int id;
    private int idU;
    private int idG;
    private String relacao;
    private Object usu;
    private Object gru;

    public UsuarioGrupo(int id) {
        this.id = id;
    }

    public UsuarioGrupo(String relacao) {
        this.relacao = relacao;
    }

    public UsuarioGrupo(int idU, int idG, String relacao) {
        this.idU = idU;
        this.idG = idG;
        this.relacao = relacao;
    }

    public UsuarioGrupo(int id, int idU, int idG, String relacao) {
        this.id = id;
        this.idU = idU;
        this.idG = idG;
        this.relacao = relacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdG() {
        return idG;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    public Object getUsu() {
        return usu;
    }

    public void setUsu(Object usu) {
        this.usu = usu;
    }

    public Object getGru() {
        return gru;
    }

    public void setGru(Object gru) {
        this.gru = gru;
    }

    @Override
    public String toString() {
        return "UsuarioGrupo{" + "id=" + id + ", idU=" + idU + ", idA=" + idG + ", tipoContrato=" + relacao + ", usu=" + usu + ", gru=" + gru + '}';
    }
    
    
    
    
}
