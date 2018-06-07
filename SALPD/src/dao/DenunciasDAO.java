package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DenunciasDAO {

    public void inserir(Denuncias t){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;

        try {
            st = c.prepareStatement("INSERT INTO Denuncias (id_usuario, telefone, local_ligacao) VALUES (?, ?, ?)");
            st.setInt(1, t.getId_usuario());
            st.setString(2, t.getTelefone());
            st.setString(3, t.getLocal_ligacao());

            st.executeUpdate();

            System.out.println("Inserção bem sucedida em Denuncias.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Denuncias.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }

    }

}
