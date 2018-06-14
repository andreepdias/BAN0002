package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuariosDAO {
    
    public boolean inserir(Usuario t){
        
        boolean sucesso = false;
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("INSERT INTO usuarios (login, senha, nome, tipo) VALUES (?, ?, ?, ?)");
            st.setString(1, t.getLogin());
            st.setString(2, t.getSenha());
            st.setString(3, t.getNome());
            st.setInt(4, t.getTipo());
            
            st.executeUpdate();
            
            sucesso = true;
            
            System.out.println("Inserção bem sucedida em Usuarios.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Usuarios.");
        }
        
        Conexao.encerrarConexao(c, st);
        return sucesso;
        
    }
    
    public Usuario login(String login, String senha){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;
        Usuario u = null;
        
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
            }
            
            System.out.println("Sucesso ao buscar na tabela Usuarios.");
            
        }catch(SQLException ex){
            System.out.println("Falha ao buscar na tabela Usuarios.");
        }
        
        return u;
        
        
    }
    
    public List<Usuario> ler(){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();
        
        try{
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
            
            System.out.println("Sucesso ao buscar na tabela Usuarios.");
            
        }catch(SQLException ex){
            System.out.println("Falha ao buscar na tabela Usuarios.");
        }
        
        return usuarios;
        
        
    }
}
