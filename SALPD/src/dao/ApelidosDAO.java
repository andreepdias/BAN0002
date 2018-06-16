package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Operacao;


public class ApelidosDAO {
    
    public void inserir(Apelido t){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();
        
        try {
            st = c.prepareStatement("INSERT INTO Apelidos (id_pessoa, apelido) VALUES (?, ?)");
            st.setInt(1, t.getId_pessoa());
            st.setString(2, t.getApelido());
            
            st.executeUpdate();
            
            o.setSucesso(true);

        } catch (SQLException ex) {
            o.addMensagem("Inserção mal sucedida em Apelidos.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }
        
    }
    
}
