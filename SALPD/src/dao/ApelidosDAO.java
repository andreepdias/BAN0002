package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ApelidosDAO {
    
    public void inserir(Apelido t){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("INSERT INTO Apelidos (id_pessoa, apelido) VALUES (?, ?)");
            st.setInt(1, t.getId_pessoa());
            st.setString(2, t.getApelido());
            
            st.executeUpdate();
            
            System.out.println("Inserção bem sucedida em Apelidos.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Apelidos.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }
        
    }
    
}
