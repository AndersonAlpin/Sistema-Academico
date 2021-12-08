/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anderson
 */
public class Agenda {
    int ID_Agenda, ID_Usuario;
    String Descricao, Date;
    Date Data;

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getData() {
        Date data = new Date();
        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        return formatData.format(Data);
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Agenda() {
    }

    public int getID_Agenda() {
        return ID_Agenda;
    }

    public void setID_Agenda(int ID_Agenda) {
        this.ID_Agenda = ID_Agenda;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
