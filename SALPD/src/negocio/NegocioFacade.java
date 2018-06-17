/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import app.Main;
import dao.*;
import java.util.List;
import modelo.*;
import util.*;

/**
 *
 * @author andre
 */
public class NegocioFacade {
    
        public static Operacao login(String login, String senha){
           UsuariosDAO dao = new UsuariosDAO();

           Operacao o = dao.login(login, senha);
           
           //Conexão foi bem sucedida mas não encontramos usuário correspondente
           if(o.isSucesso() && o.getDado() == null){
                o.setSucesso(false);
                o.addMensagem("Login ou senha inválidos.");
           }
           
           return o;
       }
       
        public static Operacao cadastrarUsuario(String login, String senha, String nome, int tipo){
           
            Operacao o = new Operacao();
            boolean valido = true;
            
            if(!Toolbox.verificaLetrasNumeros(login)){
                o.addMensagem("O Login precisa conter apenas letras e números.\n");
                valido = false;
            }
            if(!Toolbox.verificaLetras(nome)){
                o.addMensagem("O nome precisa conter apenas letras.\n");
                valido = false;
            }
            if(tipo < 0 || tipo > 5){
                o.addMensagem("O tipo precisa ser um número entre 1 e 5.\n");
                valido = false;
            }
            
            if(!valido){
                return o;
            }
                
            o.setSucesso(true);

            UsuariosDAO dao = new UsuariosDAO();
            Usuario u = new Usuario(login, senha, nome, tipo);
            
            Operacao oInsert = dao.inserir(u);
            
            o.union(oInsert);            
            
            return o;
               
        }
        public static Operacao removerUsuario(String login){
            Operacao o;            
            UsuariosDAO dao = new UsuariosDAO();            
            o = dao.remover(login);
            
            return o;
               
        }
        public static Operacao listarUsuarios(){
            UsuariosDAO dao = new UsuariosDAO();
            Operacao o = dao.listar();
            
            return o;
       }
        
        public static Operacao nomeTipo(int tipo){
            Usuario_TipoDAO dao = new Usuario_TipoDAO();
            
            Operacao o = dao.nomeTipo(tipo);
            
            if(o.isSucesso() && o.getDado() == null){
                o.setSucesso(false);
                o.addMensagem("O tipo " + tipo + "não existe.\n");
            }
        
            return o;
        }
        
        public static Operacao cadastrarPessoaDesaparecida(String nome, String rg){
           
            Operacao o = new Operacao();
            boolean valido = true;
            
            if(!Toolbox.verificaLetras(nome)){
                o.addMensagem("O nome precisa conter apenas letras.\n");
                valido = false;
            }
//            if(!Toolbox.verificaNumeros(nome, 7)){
//                o.addMensagem("O RG precisa conter apenas numeros (7).\n");
//                valido = false;
//            }
            
            if(!valido){
                return o;
            }
                
            Pessoas_DesaparecidasDAO dao = new Pessoas_DesaparecidasDAO();
            Pessoa_Desaparecida p = new Pessoa_Desaparecida(nome, rg);
            
            o = dao.inserir(p);
            
            return o;
               
        }
        public static Operacao removerPessoaDesaparecida(int id){
            Operacao o;            
            Pessoas_DesaparecidasDAO dao = new Pessoas_DesaparecidasDAO();            
            o = dao.remover(id);
            
            return o;
               
        }
        public static Operacao listarPessoasDesaparecidas(){
            Pessoas_DesaparecidasDAO dao = new Pessoas_DesaparecidasDAO();
            Operacao o = dao.listar();
            
            return o;
       }
    
        public static Operacao cadastrarDenuncia(String telefone, String local, int id){
           
            Operacao o = new Operacao();
            boolean valido = true;
            
//            if(!Toolbox.verificaLetrasENumeros(local)){
//                o.addMensagem("O local precisa conter apenas letras e números.\n");
//                valido = false;
//            }
//            if(!Toolbox.verificaNumeros(telefone, 9)){
//                o.addMensagem("O telefone precisa conter apenas numeros (9).\n");
//                valido = false;
//            }
            
            if(!valido){
                return o;
            }
                
            DenunciasDAO dao = new DenunciasDAO();
            Denuncia d = new Denuncia(id, telefone, local);
            
            o = dao.inserir(d);
            
            return o;
               
        }
        public static Operacao removerDenuncia(int id){
            Operacao o;            
            DenunciasDAO dao = new DenunciasDAO();            
            o = dao.remover(id);
            
            return o;
               
        }
        public static Operacao listarDenuncias(){
            DenunciasDAO dao = new DenunciasDAO();
            Operacao o = dao.listar();
            
            return o;
       }
    
}
