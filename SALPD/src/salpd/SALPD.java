package salpd;

import classes.Usuario_Tipos;
import dao.Usuario_TipoDAO;
import java.util.Scanner;

public class SALPD {
    
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("Digite o nome e a descrição de um novo tipo de usuário:");
        
        System.out.println("Nome: ");
        String nome = input.nextLine();
        
        System.out.println("Descricao: ");
        String descricao = input.nextLine();
        
        Usuario_Tipos t = new Usuario_Tipos(nome, descricao);
        
        Usuario_TipoDAO u = new Usuario_TipoDAO();
        
        u.inserir(t);
        
        
        
    }
    
}
