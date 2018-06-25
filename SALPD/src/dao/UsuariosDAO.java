package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Operacao;


public class UsuariosDAO {
    
    public Operacao inserir(Usuario t){
        
        Operacao o = new Operacao();
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("INSERT INTO usuarios (login, senha, nome, tipo) VALUES (?, ?, ?, ?)");
            st.setString(1, t.getLogin());
            st.setString(2, t.getSenha());
            st.setString(3, t.getNome());
            st.setInt(4, t.getTipo());
            
            st.executeUpdate();
            
            o.setSucesso(true);
            o.addMensagem("Sucesso ao inserir novo usuário.");
        } catch (SQLException ex) {
            o.addMensagem("Login já existente.\n");
        }
        
        Conexao.encerrarConexao(c, st);
        
        return o;
        
    }
    
    public Operacao remover(String login){
        
        Operacao o = new Operacao();
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("DELETE FROM usuarios WHERE login = ?");
            st.setString(1, login);
            
            st.executeUpdate();
            o.addMensagem("Sucesso ao remover usuário.\n");
            
            o.setSucesso(true);
        } catch (SQLException ex) {
            o.addMensagem("Usuário não encontrado.\n");
        }
        
        Conexao.encerrarConexao(c, st);
        
        return o;
        
    }
    
    public Operacao login(String login, String senha){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;
        Operacao o = new Operacao();
        Usuario u = new Usuario();
        
        try{
            st = c.prepareStatement("SELECT * FROM Usuarios WHERE login = ? AND senha = ?");
            st.setString(1, login);
            st.setString(2, senha);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nome"));
                u.setTipo(rs.getInt("tipo"));
                o.setDado(u);    
            }
            
            o.setSucesso(true);
                  
        }catch(SQLException ex){
            o.addMensagem("Falha ao buscar na tabela Usuários.\n");
        }
        
        Conexao.encerrarConexao(c, st);
        
        return o;
        
        
    }
    
    public Operacao getUsuario(String login){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();

        try{
            Usuario u = new Usuario();
            st = c.prepareStatement("SELECT * FROM Usuarios WHERE login = ?");
            st.setString(1, login);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nome"));
                u.setTipo(rs.getInt("tipo"));
            }
            o.setDado(u);
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao buscar na tabela Usuarios.");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o;
        
    }
    
    public Operacao listar(){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<Usuario> usuarios = null;
        
        try{
            usuarios = new ArrayList<>();
            st = c.prepareStatement("SELECT * FROM Usuarios");
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nome"));
                u.setTipo(rs.getInt("tipo"));
                
                usuarios.add(u);
            }
            o.setDado(usuarios);
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao buscar na tabela Usuarios.");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o;
    }
}
