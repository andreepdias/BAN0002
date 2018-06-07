package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuariosDAO {
    
    public void inserir(Usuarios t){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("INSERT INTO Usuarios (nome, tipo) VALUES (?, ?)");
            st.setString(1, t.getNome());
            st.setInt(2, t.getTipo());
            
            st.executeUpdate();
            
            System.out.println("Inserção bem sucedida em Usuarios.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Usuarios.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }
        
    }
    
}
