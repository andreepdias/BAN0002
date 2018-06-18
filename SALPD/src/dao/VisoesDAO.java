/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa_Desaparecida;
import visoes.*;
import util.Operacao;

/**
 *
 * @author andre
 */
public class VisoesDAO {
    
    public Operacao consultarPessoasDesaparecidas(){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<Pessoa_Desaparecida> pessoas = null;
        
        try{
            pessoas = new ArrayList<>();
            st = c.prepareStatement("SELECT * FROM visao_teste");
            rs = st.executeQuery();
            while(rs.next()){
                Pessoa_Desaparecida pessoa = new Pessoa_Desaparecida();
                pessoa.setId(rs.getInt("id"));               
                pessoa.setRG(rs.getString("RG"));  
                pessoa.setNome(rs.getString("nome"));
                pessoa.setUltimo_local(rs.getInt("ultimo_local"));                 
                pessoa.setInserido_por(rs.getInt("inserido_por"));                
                pessoa.setAtualizado_por(rs.getInt("atualizado_por"));                               
                pessoas.add(pessoa);
            }

            o.setDado(pessoas);            
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao consultar a visão de exemplo.");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o; 
    }
    
    public Operacao consultarAgentesDenunciaJoinville(){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<AgentesDenunciaJoinville> agentes = null;
        
        try{
            agentes = new ArrayList<>();
            st = c.prepareStatement("SELECT * FROM agentes_denuncia_joinville");
            rs = st.executeQuery();
            while(rs.next()){
                AgentesDenunciaJoinville agente = new AgentesDenunciaJoinville();
                agente.setId(rs.getInt("id"));               
                agente.setNome(rs.getString("nome"));  
                agente.setTelefone(rs.getString("telefone"));                              
                agentes.add(agente);
            }

            o.setDado(agentes);            
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao consultar a visão de usuários que são agentes e fizeram denúncias na cidade de Joinville.");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o; 
    }
    
}

