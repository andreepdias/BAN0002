/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import java.util.Scanner;
import modelo.*;
import modelo.consultas.*;
import negocio.NegocioFacade;
import util.*;

/**
 *
 * @author andre
 */
public class Main {

    private static Scanner input = new Scanner(System.in);
    private static Usuario usuario = null;
    

    public static void main(String[] args){

        menuLogin();
        
    }
    
    private static void menuLogin(){
        String login, senha;
        Operacao o = new Operacao();

        while(!o.isSucesso()){
            Toolbox.limpaTela();
            System.out.println("Sistema de Apoio a Localização de Pessoas Desparecidas");
            System.out.println("\nÁrea de Login:\n");
            System.out.print("Usuário: ");
            login = input.nextLine(); 
            System.out.print("Senha: ");
            senha = input.nextLine();

            o = NegocioFacade.login(login, senha);
            Main.setUsuario((Usuario) o.getDado());

            System.out.println(o.getMensagem());
          //  Toolbox.aguarda();
        }
        switch(usuario.getTipo()){
            case 5:
                menuAdministrador();
                break;
            case 4:
                menuGestor();
                break;
        }
    }
    
    private static void menuAdministrador(){
        int opcao;
        
        do{
            Toolbox.limpaTela();
            System.out.println("Menu de Administração - SALPD\n");
            System.out.println("O que você deseja fazer?");
            System.out.println("\t1 - Inserir novo usuário");
            System.out.println("\t2 - Listar todos os usuários");
            System.out.println("\t3 - Remover um usuário\n");
            System.out.println("\t4 - Cadastrar pessoa desaparecida");
            System.out.println("\t5 - Listar pessoas desaparecidas");
            System.out.println("\t6 - Remover pessoas desaparecidas\n");
            System.out.println("\t7 - Cadastrar apelido");
            System.out.println("\t8 - Listar apelidos");
            System.out.println("\t9 - Remover apelido\n");
            System.out.println("\t10 - Cadastrar denúncia");
            System.out.println("\t11 - Listar denúncias");
            System.out.println("\t12 - Remover denúncia\n");
            System.out.println("\t13 - Listar Localizações\n");
            System.out.println("\t0 - Sair\n");
            System.out.printf("$: ");
        
            opcao = Integer.parseInt(input.nextLine());
            
            switch(opcao){
                case 1:
                    menuInserirUsuario();
                    break;
                case 2:
                    menuListarUsuarios();
                    break;
                case 3:
                    menuRemoverUsuario();
                    break;
                case 4:
                    menuInserirPessoaDesparecida();
                    break;
                case 5:
                    menuListarPessoasDesparecidas();
                    break;
                case 6:
                    menuRemoverPessoaDesparecida();
                    break;
                case 7:
                    menuInserirApelido();
                    break;
                case 8:
                    menuListarApelidos();
                    break;
                case 9:
                    menuRemoverApelido();
                    break;
                case 10:
                    menuInserirDenuncia();
                    break;
                case 11:
                    menuListarDenuncias();
                    break;
                case 12:
                    menuRemoverDenuncia();
                    break;
                case 13:
                    menuListarLocalizacoes();
                    break;
            }
            
        }while(opcao != 0);
    }
    
    private static void menuGestor(){
       int opcao;
        
        do{
            Toolbox.limpaTela();
            System.out.println("Menu de Gestor - SALPD\n");
            System.out.println("O que você deseja fazer?");
            System.out.println("\t1 - Inserir novo usuário");
            System.out.println("\t2 - Listar todos os usuários");
            System.out.println("\t3 - Remover um usuário\n");
            System.out.println("\t4 - Cadastrar pessoa desaparecida");
            System.out.println("\t5 - Listar pessoas desaparecidas");
            System.out.println("\t6 - Remover pessoas desaparecidas\n");
            System.out.println("\t7 - Cadastrar apelido");
            System.out.println("\t8 - Listar apelidos");
            System.out.println("\t9 - Remover apelido\n");
            System.out.println("\t10 - Cadastrar denúncia");
            System.out.println("\t11 - Listar denúncias");
            System.out.println("\t12 - Remover denúncia\n");
            System.out.println("\t13 - Listar Localizações\n");
            System.out.println("\t0 - Sair\n");
            System.out.printf("$: ");
        
            opcao = Integer.parseInt(input.nextLine());
            
            switch(opcao){
                case 1:
                    menuInserirUsuario();
                    break;
                case 2:
                    menuListarUsuarios();
                    break;
                case 3:
                    menuRemoverUsuario();
                    break;
                case 4:
                    menuInserirPessoaDesparecida();
                    break;
                case 5:
                    menuListarPessoasDesparecidas();
                    break;
                case 6:
                    menuRemoverPessoaDesparecida();
                    break;
                case 7:
                    menuInserirApelido();
                    break;
                case 8:
                    menuListarApelidos();
                    break;
                case 9:
                    menuRemoverApelido();
                    break;
                case 10:
                    menuInserirDenuncia();
                    break;
                case 11:
                    menuListarDenuncias();
                    break;
                case 12:
                    menuRemoverDenuncia();
                    break;
                case 13:
                    menuListarLocalizacoes();
                    break;
            }
            
        }while(opcao != 0);  
    }
    
    private static void menuInserirUsuario(){
        String login, senha, nome;
        int tipo;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Cadastro de novo usuário:\n");
        System.out.printf("Login: ");
        login = input.nextLine();
        System.out.printf("Senha: ");
        senha = input.nextLine();
        System.out.printf("Nome: ");
        nome = input.nextLine();
        System.out.printf("Tipo: ");
        tipo = Integer.parseInt(input.nextLine());

        o = NegocioFacade.cadastrarUsuario(usuario.getTipo(), login, senha, nome, tipo);

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuRemoverUsuario(){
        String login;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Remoção de usuário:\n");
        System.out.printf("Login: ");
        login = input.nextLine();

        o = NegocioFacade.removerUsuario(usuario.getTipo(), login);

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuListarUsuarios(){
        Operacao o;
        
        Toolbox.limpaTela();

        o = NegocioFacade.listarUsuarios();
        System.out.printf(o.getMensagem());

        if(o.isSucesso()){
            System.out.println("Lista de usuários:\n");
            System.out.println("Id - Login - Senha - Nome - Tipo");
            for(listarUsuarios l : (List<listarUsuarios>) o.getDado()){
//                String nomeTipo = (String) NegocioFacade.nomeTipo(u.getTipo()).getDado();
                System.out.println(l.getId() + "\t-\t" + l.getLogin() + "\t-\t" + l.getSenha() + "\t-\t" + l.getNome() + "\t-\t" + l.getTipo());
            }      
        }
        Toolbox.aguarda();
    }
    
    private static void menuInserirPessoaDesparecida(){
        String nome, rg;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Cadastro de nova pessoa desaparecida:\n");
        System.out.printf("Nome: ");
        nome = input.nextLine();
        System.out.printf("RG: ");
        rg = input.nextLine();

        o = NegocioFacade.cadastrarPessoaDesaparecida(nome, rg, getUsuario().getId(), getUsuario().getId());

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuRemoverPessoaDesparecida(){
        int id;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Remoção de pessoa desaparecida:\n");
        System.out.printf("Id: ");
        id = Integer.parseInt(input.nextLine());

        o = NegocioFacade.removerPessoaDesaparecida(id);

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuListarPessoasDesparecidas(){
        Operacao o;
        
        Toolbox.limpaTela();

        o = NegocioFacade.listarPessoasDesaparecidas();
        System.out.printf(o.getMensagem());

        if(o.isSucesso()){
            System.out.println("Lista de Pessoas Desaparecidas:\n");
            System.out.println("Id\t-\tNome\t-\tRG");
            for(Pessoa_Desaparecida p : (List<Pessoa_Desaparecida>) o.getDado()){
                System.out.println(p.getId() + "\t-\t" + p.getNome() + "\t-\t" + p.getRG());
//                System.out.println("Inserido por: " + p.getInserido_por());
//                System.out.println("Atualizado por: " + p.getAtualizado_por());
            }      
        }
        Toolbox.aguarda();
    }
    
    private static void menuInserirApelido(){
        
        String apelido;
        int id_pessoa;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Cadastro de um apelido para uma pessoa desaparecida:\n");
        System.out.printf("Apelido: ");
        apelido = input.nextLine();
        System.out.printf("ID da pessoa: ");
        id_pessoa = Integer.parseInt(input.nextLine());

        o = NegocioFacade.cadastrarApelido(id_pessoa, apelido);

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuRemoverApelido(){
        int id;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Remoção de apelido:\n");
        System.out.printf("Id: ");
        id = Integer.parseInt(input.nextLine());

        o = NegocioFacade.removerApelido(id);

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuListarApelidos(){
        Operacao o;
        int id_pessoa;
        
        Toolbox.limpaTela();
        System.out.println("Lista de apelidos de uma pessoa desaparecida:\n");
        System.out.printf("ID da pessoa des.: ");
        id_pessoa = Integer.parseInt(input.nextLine());

        o = NegocioFacade.listarApelidos(id_pessoa);
        System.out.println(o.getMensagem());

        if(o.isSucesso()){
            System.out.println("Lista de Apelidos:\n");
            System.out.println("Id\t-\tApelido");
            for(Apelido a : (List<Apelido>) o.getDado()){
                System.out.println(a.getId() + "\t-\t" + a.getApelido());
            }      
        }
        Toolbox.aguarda();
    }
    
    private static void menuInserirDenuncia(){
        String telefone, local_ligacao, local, data, hora;
        int id_usuario, id_pessoa;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Cadastro de nova denúncia:\n");
        System.out.println("Dados de quem está denunciando:");
        System.out.printf("Telefone: ");
        telefone = input.nextLine();
        System.out.printf("Local: ");
        local_ligacao = input.nextLine();
        
        System.out.println("\nDados da pessoa desaparecida:");
        System.out.printf("ID: ");
        id_pessoa = Integer.parseInt(input.nextLine());
        System.out.printf("Local: ");
        local = input.nextLine();
        System.out.printf("Data: ");
        data = input.nextLine();
        System.out.printf("Hora: ");
        hora = input.nextLine();

        o = NegocioFacade.cadastrarDenuncia(telefone, local_ligacao, getUsuario().getId());
        
//        System.out.println(o.getMensagem());
        
        /** Caso consiga cadastrar uma denúncia, cadastra a localização referente à essa denúncia**/
        if(o.isSucesso()){
            o = NegocioFacade.cadastrarLocalizacao(id_pessoa, (int)o.getDado(), local, data, hora);
            
            /** Caso consiga cadastrar a localização, atualiza a última localização na tabela de pessoas_desaparecidas**/
            if(o.isSucesso()){
                o = NegocioFacade.atualizarLocalizacao(id_pessoa, (int)o.getDado());
                
                System.out.println(o.getMensagem());
            }
            
        }else{
//            o = NegocioFacade.removerDenuncia((int)o.getDado());
            System.out.println(o.getMensagem());
        }
        Toolbox.aguarda();
        
    }
    private static void menuRemoverDenuncia(){
        int id;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Remoção de denúncia:\n");
        System.out.printf("Id: ");
        id = Integer.parseInt(input.nextLine());

        o = NegocioFacade.removerLocalizacao(id);
        if(o.isSucesso()){
               o = NegocioFacade.removerDenuncia(id);
        }

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuListarDenuncias(){
        Operacao o;
        
        Toolbox.limpaTela();

        o = NegocioFacade.listarDenuncias();
        System.out.printf(o.getMensagem());

        if(o.isSucesso()){
            System.out.println("Lista de Denúncias:\n");
            System.out.println("Id\t-\tTelefone\t-\tLocal");
            for(Denuncia d : (List<Denuncia>) o.getDado()){
                System.out.println(d.getId() + "\t-\t" + d.getTelefone() + "\t-\t" + d.getLocal_ligacao());
//                System.out.println("Inserido por: " + d.getId_usuario());
            }      
        }
        Toolbox.aguarda();
    }

    private static void menuListarLocalizacoes(){
        int id_pessoa;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Digite o ID da pessoa desaparecida:");
        id_pessoa = Integer.parseInt(input.nextLine());
            
        o = NegocioFacade.listarLocalizacoes(id_pessoa);
        System.out.printf(o.getMensagem());

        if(o.isSucesso()){
            System.out.println("Lista de Localizações:\n");
            System.out.println("Id\t-\tId_pessoa\t-\tId_denuncia\t-\tLocal\t-\tData\t-\tHora");
            for(Localizacao l : (List<Localizacao>) o.getDado()){
                System.out.println(l.getId() + "\t-\t" + l.getId_pessoa() + "\t-\t" + l.getId_denuncia() + "\t-\t" + l.getLocal() + "\t-\t" + l.getData() + "\t-\t\t    " + l.getHora());
//                System.out.println("Inserido por: " + d.getId_usuario());
            }      
        }
        Toolbox.aguarda();
    }

    
    public static Usuario getUsuario() {
        return usuario;
    }
    public static void setUsuario(Usuario u){
        usuario = u;
    }
}
