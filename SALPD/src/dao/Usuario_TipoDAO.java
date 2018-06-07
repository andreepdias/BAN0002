package dao;

import classes.Usuario_Tipos;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Usuario_TipoDAO {
    
    public void inserir(Usuario_Tipos t){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("INSERT INTO Usuario_Tipos (nome, descricao) VALUES (?, ?)");
            st.setString(1, t.getNome());
            st.setString(2, t.getDescricao());
            
            st.executeUpdate();
            
            System.out.println("Inserção bem sucedida em Usuario_Tipos.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Usuario_Tipos.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }
        
    }
    
}
