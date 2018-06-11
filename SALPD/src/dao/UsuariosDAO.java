package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuariosDAO {
    
    public boolean inserir(Usuario t){
        
        boolean sucesso = false;
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("INSERT INTO Usuarios (nome, tipo, login, senha) VALUES (?, ?, ?, ?)");
            st.setString(1, t.getNome());
            st.setInt(2, t.getTipo());
            st.setString(3, t.getLogin());
            st.setString(4, t.getSenha());
            
            st.executeUpdate();
            
            sucesso = true;
            
            System.out.println("Inserção bem sucedida em Usuarios.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Usuarios.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }
        
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
    
}
