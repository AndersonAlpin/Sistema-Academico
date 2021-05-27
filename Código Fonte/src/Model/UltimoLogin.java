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
public class UltimoLogin {
    String Email, Senha;
    int ID_UltimoLogin;

    public UltimoLogin() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int getID_UltimoLogin() {
        return ID_UltimoLogin;
    }

    public void setID_UltimoLogin(int ID_UltimoLogin) {
        this.ID_UltimoLogin = ID_UltimoLogin;
    }
}
