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
public class Sessao extends UsuarioM{
    
    private Sessao(){
        
    }
    
    private static Sessao instancia = null;
    
    public static Sessao getInstancia(){
        if(instancia == null){
            instancia = new Sessao();
        }
        return instancia;
    }
}
