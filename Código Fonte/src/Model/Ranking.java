/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;

/**
 *
 * @author Anderson
 */
public class Ranking {
    int ID_Ranking, ID_Usuario, scoreDia, scoreTotal, erros,
            acertos, ignorados, totalSimulados, Posicao;
    String data, Nome, Sobrenome;

    public int getPosicao() {
        return Posicao;
    }

    public void setPosicao(int Posicao) {
        this.Posicao = Posicao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }

    public Ranking() {
    }

    public int getID_Ranking() {
        return ID_Ranking;
    }

    public void setID_Ranking(int ID_Ranking) {
        this.ID_Ranking = ID_Ranking;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public int getScoreDia() {
        return scoreDia;
    }

    public void setScoreDia(int scoreDia) {
        this.scoreDia = scoreDia;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getIgnorados() {
        return ignorados;
    }

    public void setIgnorados(int ignorados) {
        this.ignorados = ignorados;
    }

    public int getTotalSimulados() {
        return totalSimulados;
    }

    public void setTotalSimulados(int totalSimulados) {
        this.totalSimulados = totalSimulados;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
