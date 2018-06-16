/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import java.util.Scanner;
import modelo.*;
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
            System.out.print("Usuário:\t");
            login = input.nextLine(); 
            System.out.print("Senha:\t");
            senha = input.nextLine();

            o = NegocioFacade.login(login, senha);
            Main.setUsuario((Usuario) o.getDado());

            System.out.println(o.getMensagem());
          //  Toolbox.aguarda1s();
        }
            switch(usuario.getTipo()){
            case 5:
                menuAdministrador();
                break;
        }
    }
    
    private static void menuAdministrador(){
        int opcao;
        
        do{
            Toolbox.limpaTela();
            System.out.println("Menu de Administração - SALPD\n");
            System.out.println("O que você deseja realizar?");
            System.out.println("\t1 - Inserir novo usuário");
            System.out.println("\t2 - Listar todos os usuários");
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
            }
            
        }while(opcao != 0);
    }
    
    private static void menuInserirUsuario(){
        String login, senha, nome;
        int tipo;
        Operacao o = new Operacao();
        
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

        o = NegocioFacade.cadastrarUsuario(login, senha, nome, tipo);

        System.out.printf(o.getMensagem());
        //Toolbox.aguarda1s();
    }
    
    private static void menuListarUsuarios(){
        Operacao o = new Operacao();
        
        Toolbox.limpaTela();

        o = NegocioFacade.listarUsuarios();

        if(o.isSucesso()){
            int i = 1;
            for(Usuario u : (List<Usuario>) o.getDado()){
                String nomeTipo = (String) NegocioFacade.nomeTipo(u.getTipo()).getDado();
                System.out.println("Usuario " + i);
                System.out.println("\tNome: " + u.getNome());
                System.out.println("\tTipo: " +  nomeTipo);
                i++;
            }      
        }
        else{
            System.out.printf(o.getMensagem());
        }
       // Toolbox.aguarda1s();
        
    }
    
    public static void setUsuario(Usuario u){
        usuario = u;
    }
}
