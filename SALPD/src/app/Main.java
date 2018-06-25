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
import visoes.*;

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
        int opcao = 0;
        Operacao o = new Operacao();

        while(!o.isSucesso() && opcao != 1 && opcao != 2){
            Toolbox.limpaTela();
            System.out.println("Sistema de Apoio a Localização de Pessoas Desparecidas");
            System.out.println("O que você deseja fazer?");
            System.out.println("\t1 - Fazer login");
            System.out.println("\t2 - Entrar como Informante Anônimo");
            System.out.print("$: ");
            opcao = Integer.parseInt(input.nextLine());
            Toolbox.limpaTela();
           
            switch(opcao)
            {
                case 1:
                    System.out.println("\nÁrea de Login:\n");
                    System.out.print("Usuário: ");
                    login = input.nextLine(); 
                    System.out.print("Senha: ");
                    senha = input.nextLine();

                    o = NegocioFacade.login(login, senha);
                    Main.setUsuario((Usuario) o.getDado());

                    System.out.println(o.getMensagem());
                    switch(usuario.getTipo()){
                        case 5:
                            menuAdministrador();
                            break;
                        case 4:
                            menuGestor();
                            break;
                        case 3:
                            menuAgente();
                            break;
                        case 2:
                            menuInformante();
                            break;
                    } 
                    break;
                case 2:
                    //Main.setUsuario(); //Precisa de um usuário anonimo pra colocar aqui
                    break;
                    
            }
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
            System.out.println("\t14 - Buscar por visões\n");
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
                    menuListarPessoasDesaparecidas();
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
                case 14:
                    menuVisoes();
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
            System.out.println("\t14 - Buscar por visões\n");
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
                    menuListarPessoasDesaparecidas();
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
                case 14:
                    menuVisoes();
                    break;
            }
            
        }while(opcao != 0);  
    }
    
    private static void menuAgente(){
       int opcao;
        
        do{
            Toolbox.limpaTela();
            System.out.println("Menu de Agente - SALPD\n");
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
            System.out.println("\t14 - Buscar por visões\n");
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
                    menuListarPessoasDesaparecidas();
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
                case 14:
                    menuVisoes();
                    break;
            }
            
        }while(opcao != 0);  
    }
    
    private static void menuInformante(){
       int opcao;
        
        do{
            Toolbox.limpaTela();
            System.out.println("Menu de Informante - SALPD\n");
            System.out.println("O que você deseja fazer?");
            System.out.println("\t1 - Listar pessoas desaparecidas");
            System.out.println("\t2 - Cadastrar denúncia");
            System.out.println("\t0 - Sair\n");
            System.out.printf("$: ");
        
            opcao = Integer.parseInt(input.nextLine());
            
            switch(opcao){
                case 1:
                    menuListarPessoasDesaparecidas();
                    break;
                case 2:
                    menuInserirDenuncia();
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
        String rg, cpf, nome;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Cadastro de nova pessoa desaparecida:\n");
        System.out.printf("Nome: ");
        nome = input.nextLine();
        System.out.printf("RG: ");
        rg = input.nextLine();
        System.out.printf("CPF: ");
        cpf = input.nextLine();

        o = NegocioFacade.cadastrarPessoaDesaparecida(rg, cpf, nome, getUsuario().getId(), getUsuario().getId());

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuRemoverPessoaDesparecida(){
        String cpf;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Remoção de pessoa desaparecida:\n");
        System.out.printf("CPF: ");
        cpf = input.nextLine();

        o = NegocioFacade.removerPessoaDesaparecida(cpf);

        System.out.println(o.getMensagem());
        Toolbox.aguarda();
    }
    private static void menuListarPessoasDesaparecidas(){
        Operacao o;
        
        Toolbox.limpaTela();

        o = NegocioFacade.listarPessoasDesaparecidas();
        System.out.printf(o.getMensagem());

        if(o.isSucesso()){
            System.out.println("Lista de Pessoas Desaparecidas:\n");
            System.out.println("Id\t-\tNome\t-\tRG\t-\tCPF");
            for(Pessoa_Desaparecida p : (List<Pessoa_Desaparecida>) o.getDado()){
                System.out.println(p.getId() + "\t-\t" + p.getNome() + "\t-\t" + p.getRG() + "\t-\t" + p.getCPF());
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
        String cpf;
        
        Toolbox.limpaTela();
        System.out.println("Lista de apelidos de uma pessoa desaparecida:\n");
        System.out.printf("ID da pessoa des.: ");
        cpf = input.nextLine();

        o = NegocioFacade.listarApelidos(cpf);
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
        String telefone, local_ligacao, local, data, hora, cpf;
        int id_usuario;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Cadastro de nova denúncia:\n");
        System.out.println("Dados de quem está denunciando:");
        System.out.printf("Telefone: ");
        telefone = input.nextLine();
        System.out.printf("Local: ");
        local_ligacao = input.nextLine();
        
        System.out.println("\nDados da pessoa desaparecida:");
        System.out.printf("CPF: ");
        cpf = input.nextLine();
        System.out.printf("Local: ");
        local = input.nextLine();
        System.out.printf("Data (AAAA-MM-DD): ");
        data = input.nextLine();
        System.out.printf("Hora (HH:MM:SS): ");
        hora = input.nextLine();

        o = NegocioFacade.cadastrarDenuncia(cpf, telefone, local_ligacao, getUsuario().getId(), data, hora);
               
        
        if(!o.isSucesso()){
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
    
    private static void menuVisoes(){
        int escolha_visao;
        Operacao o;
        
        Toolbox.limpaTela();
        System.out.println("Escolha uma dentre as visões disponíveis:");
        System.out.println("\t1 - Pessoas desaparecidas a menos de 6 meses, com informação de localização fornecida a menos de 7 dias por denúncia de um informante");
        System.out.println("\t2 - Usuários que são agentes e fizeram denúncias na cidade de Joinville");

        
        escolha_visao = Integer.parseInt(input.nextLine());
        
        switch(escolha_visao){
            case 1:
                o = NegocioFacade.consultarVisao(escolha_visao);
                System.out.printf(o.getMensagem());
                if(o.isSucesso()){
                    System.out.println("Id\t-\tRG\t-\tNome");
                    for(Pessoa_Desaparecida p : (List<Pessoa_Desaparecida>) o.getDado()){
                        System.out.println(p.getId() + "\t-\t" + p.getRG() + "\t-\t" + p.getNome());
                    }      
                }
            break;
            case 2:
                o = NegocioFacade.consultarVisao(escolha_visao);
                System.out.printf(o.getMensagem());
                if(o.isSucesso()){
                    System.out.println("Id\t-\tNome\t-\tTelefone");
                    for(AgentesDenunciaJoinville p : (List<AgentesDenunciaJoinville>) o.getDado()){
                        System.out.println(p.getId() + "\t-\t" + p.getNome() + "\t-\t" + p.getTelefone());
                    }      
                }
            break;
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
