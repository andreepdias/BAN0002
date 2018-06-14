/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author andre
 */
public class Operacao {

    private boolean sucesso;
    private String mensagem;
    private Object dado;

    public Operacao() {
        sucesso = false;
        mensagem = "";
    }
    
    public Operacao(Object dado) {
        sucesso = false;
        mensagem = "";
        this.dado = dado;
    }

    public Operacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Object getDado(){
        return dado;
    }
    
    public void setDado(Object dado){
        this.dado = dado;
    }

    
}
