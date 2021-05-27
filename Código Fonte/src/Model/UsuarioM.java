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
public class UsuarioM {
    
    String Nome, Sobrenome, Senha, Email, Telefone;
    int ID_Usuario, isAdm, usuarioAtivo;

    public UsuarioM() {
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
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

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public int getIsAdm() {
        return isAdm;
    }

    public void setIsAdm(int isAdm) {
        this.isAdm = isAdm;
    }

    public int getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(int usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }
    
    public void mostraUsuarios(){
        System.out.println(("ID: " + getID_Usuario()));
        System.out.println("Nome: " + getNome());
        System.out.println("Sobrenome: " + getSobrenome());
        System.out.println("Email: " + getEmail());
        System.out.println("Senha: " + getSenha());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Adm ou User: " + getIsAdm());
        System.out.println("Ativo ou não ativo: " + getUsuarioAtivo());
        System.out.println("==============================");
    }
}
