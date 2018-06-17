/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Toolbox {
    
    public static void aguarda(){
//        try { Thread.sleep (3000); } catch (InterruptedException ex) {};
        
        System.out.println("\n(pressione enter para continuar)");
        Scanner input = new Scanner(System.in);
        String i = input.nextLine();
    }

    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static boolean verificaLetras(String s){
        if(s.matches("[a-zA-Z*]")){
            return true;
        }
        return true;
    }
    
    public static boolean verificaLetrasNumeros(String s){
        if(s.matches("[a-zA-Z0-9*]")){
            return true;
        }
        return true;
    }
    
}
