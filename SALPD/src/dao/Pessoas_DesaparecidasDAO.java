package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Pessoas_DesaparecidasDAO {

    public void inserir(Pessoas_Desaparecidas t){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;

        try {
            st = c.prepareStatement("INSERT INTO Pessoas_Desaparecidas (RG, nome, ultimo_local, inserido_por, atualizado_por) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, t.getRG());
            st.setString(2, t.getNome());
            st.setString(3, t.getUltimo_local());
            st.setInt(4, t.getInserido_por());
            st.setInt(5, t.getAtualizado_por());

            st.executeUpdate();

            System.out.println("Inserção bem sucedida em Pessoas_Desaparecidas.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Pessoas_Desaparecidas.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }

    }

}
