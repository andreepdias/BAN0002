/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import app.Main;
import dao.*;
import modelo.*;
import util.*;

/**
 *
 * @author andre
 */
public class NegocioFacade {
    
       public static Operacao login(String login, String senha){
           
           Operacao o = new Operacao();
           UsuariosDAO dao = new UsuariosDAO();
           
           Usuario u = dao.login(login, senha);

           if(u == null){
               o.setSucesso(false);
               o.setMensagem("Login ou senha inválidos.");
           }else{
               o.setSucesso(true);
               o.setMensagem("Sucesso na autenticação.");
               Main.setUsuario(u);
           }
           
           return o;
       }
       
       public static Operacao cadastrarUsuario(String login, String senha, String nome, int tipo){
           
            Operacao o = new Operacao();
            StringBuilder s = new StringBuilder();
            
            if(!Toolbox.verificaLetrasNumeros(login)){
                s.append("O Login precisa conter apenas letras e números.\n");
            }
            if(!Toolbox.verificaLetras(nome)){
                s.append("O nome precisa conter apenas letras.\n");
            }
            if(tipo < 0 || tipo > 5){
                s.append("O tipo precisa ser um número entre 1 e 5.\n");
            }

            UsuariosDAO dao = new UsuariosDAO();
            Usuario u = new Usuario(login, senha, nome, tipo);
                    
            if(!dao.inserir(u)){
                s.append("Login e/ou senha já existem.");
            }
            
            o.setMensagem(s.toString());
            
            if(o.getMensagem() == null){
                o.setSucesso(true);
                o.setMensagem("Sucesso no cadastro do usuário.");
            }
            
            return o;
           
       }
    
}
