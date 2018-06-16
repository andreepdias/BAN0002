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
    private StringBuilder mensagem;
    private Object dado;

    public Operacao() {
        sucesso = false;
        mensagem = new StringBuilder();
    }
    
    public Operacao(Object dado) {
        sucesso = false;
        mensagem = new StringBuilder();
        this.dado = dado;
    }

    public Operacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = new StringBuilder();
        this.mensagem.append(mensagem);
    }
    
    //Se precisarmos juntar as mensagens de duas operações
    public void union(Operacao o){
        this.sucesso = this.sucesso && o.isSucesso();
        this.mensagem.append(o.getMensagem());
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem.toString();
    }

    public void addMensagem(String mensagem) {
        this.mensagem.append(mensagem);
    }
    
    public Object getDado(){
        return dado;
    }
    
    public void setDado(Object dado){
        this.dado = dado;
    }

    
}
