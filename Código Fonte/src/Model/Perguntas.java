/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Anderson
 */
public class Perguntas {
    String Descricao, alternativaA, alternativaB, alternativaC,
            alternativaD, alternativaE, alternativaCorreta, Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    int ID_Pergunta, ID_Materia, Dificuldade, Valor;

    public Perguntas() {
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public int getID_Pergunta() {
        return ID_Pergunta;
    }

    public void setID_Pergunta(int ID_Pergunta) {
        this.ID_Pergunta = ID_Pergunta;
    }

    public int getID_Materia() {
        return ID_Materia;
    }

    public void setID_Materia(int ID_Materia) {
        this.ID_Materia = ID_Materia;
    }

    public int getDificuldade() {
        return Dificuldade;
    }

    public void setDificuldade(int Dificuldade) {
        this.Dificuldade = Dificuldade;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }
    
    public void mostrar(){
        System.out.println(getDescricao());
        System.out.println("--------------------------------------");
        System.out.println(getAlternativaA());
        System.out.println("--------------------------------------");
        System.out.println(getAlternativaB());
        System.out.println("--------------------------------------");
        System.out.println(getAlternativaC());
        System.out.println("--------------------------------------");
        System.out.println(getAlternativaD());
        System.out.println("--------------------------------------");
        System.out.println(getAlternativaE());
        System.out.println("=======================================");
        System.out.println("=======================================");
    }
}
