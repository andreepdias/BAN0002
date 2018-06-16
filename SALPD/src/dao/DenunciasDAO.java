package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Operacao;


public class DenunciasDAO {

    public void inserir(Denuncia t){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();

        try {
            st = c.prepareStatement("INSERT INTO Denuncias (id_usuario, telefone, local_ligacao) VALUES (?, ?, ?)");
            st.setInt(1, t.getId_usuario());
            st.setString(2, t.getTelefone());
            st.setString(3, t.getLocal_ligacao());

            st.executeUpdate();

            o.setSucesso(true);
            
        } catch (SQLException ex) {
            o.addMensagem("Inserção mal sucedida em Denuncias.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }

    }

}
