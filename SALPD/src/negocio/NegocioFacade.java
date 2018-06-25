/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.*;
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
       
    public static Operacao cadastrarUsuario(int tipoUsuarioMain, String login, String senha, String nome, int tipo){

        Operacao o = new Operacao();
        boolean valido = true;
        
        if(!Toolbox.comparaTipos(tipoUsuarioMain, tipo)){
            o.addMensagem("Você não têm permissão para cadastrar esse tipo de usuário.\n");
            valido = false;
        }
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
    public static Operacao removerUsuario(int tipoUsuarioMain, String login){
        Operacao o;
        
       UsuariosDAO temp = new UsuariosDAO();
       o = temp.getUsuario(login);
       
       if(o.isSucesso()){
          if(o.getDado() == null){
              o.setSucesso(false);
              o.addMensagem("Não existe usuário com o login informado.\n");
              return o;
          }
          if(!Toolbox.comparaTipos(tipoUsuarioMain, ((Usuario) o.getDado()).getTipo())){
              o.setSucesso(false);
              o.setDado(null);
              o.addMensagem("Você não têm permissão para remover esse tipo de usuário.\n");
              return o;
          }
          
          UsuariosDAO dao = new UsuariosDAO();          
          o = dao.remover(login);
       }
       return o;

    }
    public static Operacao listarUsuarios(){
        ConsultasDAO dao = new ConsultasDAO();
        Operacao o = dao.listarUsuarios();

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
        
    public static Operacao cadastrarPessoaDesaparecida(String rg, String cpf, String nome, int inserido_por, int atualizado_por){

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
        Pessoa_Desaparecida p = new Pessoa_Desaparecida(rg, cpf, nome, inserido_por, atualizado_por);

        o = dao.inserir(p);

        return o;

    }
    public static Operacao removerPessoaDesaparecida(String cpf){
        Operacao o;            
        Pessoas_DesaparecidasDAO dao = new Pessoas_DesaparecidasDAO();            
        o = dao.remover(cpf);

        return o;

    }
    public static Operacao listarPessoasDesaparecidas(){
        Pessoas_DesaparecidasDAO dao = new Pessoas_DesaparecidasDAO();
        Operacao o = dao.listar();

        return o;
   }
        
    public static Operacao cadastrarApelido(int id_pessoa, String apelido){

        Operacao o = new Operacao();
        boolean valido = true;

        if(!Toolbox.verificaLetras(apelido)){
            o.addMensagem("O apelido precisa conter apenas letras.\n");
            valido = false;
        }
//            if(!Toolbox.verificaNumeros(nome, 7)){
//                o.addMensagem("O RG precisa conter apenas numeros (7).\n");
//                valido = false;
//            }

        if(!valido){
            return o;
        }

        ApelidosDAO dao = new ApelidosDAO();
        Apelido a = new Apelido(id_pessoa, apelido);

        o = dao.inserir(a);

        return o;

    }
    public static Operacao removerApelido(int id){
        Operacao o;            
        ApelidosDAO dao = new ApelidosDAO();            
        o = dao.remover(id);

        return o;

    }
    public static Operacao listarApelidos(String cpf){
        Pessoas_DesaparecidasDAO usDao = new Pessoas_DesaparecidasDAO();
        Operacao o = usDao.getPessoa(cpf);
        if(o.isSucesso()){
           if(o.getDado() != null){
                ApelidosDAO dao = new ApelidosDAO();
                o = dao.listar(cpf); 
           }
           else{
               o.setSucesso(false);
               o.addMensagem("Não há nenhuma pessoa desaparecida registrada com esse CPF.");
           }
        }
        
        


        return o;
   }

    public static Operacao cadastrarDenuncia(String cpf, String telefone, String local, int id, String data, String hora){

        Operacao o = new Operacao();
        Operacao o2 = new Operacao();
        Operacao o3 = new Operacao();
        Pessoa_Desaparecida denunciado ;
        
        Pessoas_DesaparecidasDAO daop = new Pessoas_DesaparecidasDAO();
        o = daop.getPessoa(cpf);
        if(o.isSucesso()){
            if(o.getDado() == null){
                o.addMensagem("Não existe pessoa desaparecida com esse CPF.");
                o.setSucesso(false);
                return o;
            }
        }
        else{
            return o;
        }
        denunciado = (Pessoa_Desaparecida) o.getDado();

        DenunciasDAO daod = new DenunciasDAO();
        LocalizacoesDAO daol = new LocalizacoesDAO();
        Denuncia d = new Denuncia(id, telefone, local);

        o = daod.inserir(d);
        
        /** Caso consiga cadastrar uma denúncia, cadastra a localização referente à essa denúncia**/
        if(o.isSucesso()){
            o2 = cadastrarLocalizacao(denunciado.getId(), (int)o.getDado(), local, data, hora);

            /** Caso consiga cadastrar a localização, atualiza a última localização na tabela de pessoas_desaparecidas**/
            if(o2.isSucesso()){
                o3 = atualizarLocalizacao(denunciado.getCPF(), (int)o2.getDado());
                
                if(!o3.isSucesso()){
                    daod.remover((int) o.getDado());
                    daol.remover((int) o2.getDado());
                }
            }
            else{
                daod.remover((int) o.getDado());
            }
        }
        o.union(o2);
        o.union(o3);
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
        
    public static Operacao cadastrarLocalizacao(int id_pessoa, int id_denuncia, String local, String data, String hora){

        Operacao o = new Operacao();

        LocalizacoesDAO dao = new LocalizacoesDAO();
        Localizacao l = new Localizacao(id_pessoa, id_denuncia, local, data, hora);

        o = dao.inserir(l);



        return o;
    }
    public static Operacao removerLocalizacao(int id){
        Operacao o;            
        LocalizacoesDAO dao = new LocalizacoesDAO();            
        o = dao.remover(id);

        return o;

    }
    public static Operacao listarLocalizacoes(int id_pessoa){
        LocalizacoesDAO dao = new LocalizacoesDAO();
        Operacao o = dao.listar(id_pessoa);

        return o;
   }
    public static Operacao atualizarLocalizacao(String cpf, int id_localizacao){

        Operacao o;
        
        Pessoas_DesaparecidasDAO dao = new Pessoas_DesaparecidasDAO();

        o = dao.atualizar(cpf, id_localizacao);

        return o;
    }
    
    public static Operacao consultarVisao(int ind_visao){
        VisoesDAO dao = new VisoesDAO();
        Operacao o = null;
        switch(ind_visao){
            case 1:
                o = dao.consultarPessoasDesaparecidas();            
                break;
            case 2:
                o = dao.consultarAgentesDenunciaJoinville();
                break;
        }        

        return o;
   }
        

    
}
