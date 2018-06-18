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
import modelo.consultas.*;
import util.Operacao;

/**
 *
 * @author andre
 */
public class ConsultasDAO {
    
    public Operacao listarUsuarios(){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<listarUsuarios> lista = null;
        
        try{
            lista = new ArrayList<>();
            st = c.prepareStatement("SELECT u.id, u.login, u.senha, u.nome, t.nome as tipo FROM Usuarios u JOIN Usuario_Tipos t ON (u.tipo = t.id)");
            
            rs = st.executeQuery();
            
            while(rs.next()){
                listarUsuarios l = new listarUsuarios();
                l.setId(rs.getInt("id"));
                l.setLogin(rs.getString("login"));
                l.setSenha(rs.getString("senha"));
                l.setNome(rs.getString("nome"));
                l.setTipo(rs.getString("tipo"));
                
                lista.add(l);
            }
            o.setDado(lista);
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao consultar todos os usuários.");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o;
    }
    
    public Operacao findTipoUsuario(String login){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        ResultSet rs = null;

        Operacao o = new Operacao();
        String nomeTipo = null;
        
        try{
            st = c.prepareStatement("SELECT nome FROM Usuarios u JOIN Usuario_Tipos t ON (u.tipo = t.id AND u.login = ?)");
            st.setString(1, login);
            rs = st.executeQuery();
            
            rs.next();
            o.setDado(rs.getString("nome"));
            
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao consultar o tipo do usuário.");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o; 
    }
    
}

