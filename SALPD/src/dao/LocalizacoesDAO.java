package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LocalizacoesDAO {

    public void inserir(Localizacoes t){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;

        try {
            st = c.prepareStatement("INSERT INTO Localizacoes (id_pessoa, local, data_hora) VALUES (?, ?, ?)");
            st.setInt(1, t.getId_pessoa());
            st.setString(2, t.getLocal());
            st.setString(3, t.getData_hora());

            st.executeUpdate();

            System.out.println("Inserção bem sucedida em Localizacoes.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Localizacoes.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }

    }

}
