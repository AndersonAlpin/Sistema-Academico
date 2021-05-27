/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Anderson
 */
public class Materias {
    String Nome;
    int ID_Materia, isAtiva;

    public int getIsAtiva() {
        return isAtiva;
    }

    public void setIsAtiva(int isAtiva) {
        this.isAtiva = isAtiva;
    }
    private CheckBox select;

    public Materias(String Nome, int ID_Materia, CheckBox select) {
        this.Nome = Nome;
        this.ID_Materia = ID_Materia;
        this.select = new CheckBox();
    }
    
    public Materias() {
    }
    
    @Override
    public String toString() {
        return getNome();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getID_Materia() {
        return ID_Materia;
    }

    public void setID_Materia(int ID_Materia) {
        this.ID_Materia = ID_Materia;
    }
    
    public CheckBox getSelect(){
        return select;
    }
    
    public void setSelect(CheckBox select){
        this.select = select;
    }
}
