package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Operacao;


public class LocalizacoesDAO {

    public void inserir(Localizacao t){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();

        try {
            st = c.prepareStatement("INSERT INTO Localizacoes (id_pessoa, local, data_hora) VALUES (?, ?, ?)");
            st.setInt(1, t.getId_pessoa());
            st.setString(2, t.getLocal());
            st.setString(3, t.getData_hora());

            st.executeUpdate();

            o.setSucesso(true);
            
        } catch (SQLException ex) {
            o.addMensagem("Inserção mal sucedida em Localizacoes.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }

    }

}
