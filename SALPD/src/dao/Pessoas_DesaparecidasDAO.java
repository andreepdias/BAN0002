package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Operacao;


public class Pessoas_DesaparecidasDAO {

    public Operacao inserir(Pessoa_Desaparecida t){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();

        try {
            st = c.prepareStatement("INSERT INTO Pessoas_Desaparecidas (RG, nome, ultimo_local, inserido_por, atualizado_por) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, t.getRG());
            st.setString(2, t.getNome());
            st.setString(3, t.getUltimo_local());
            st.setInt(4, t.getInserido_por());
            st.setInt(5, t.getAtualizado_por());

            st.executeUpdate();

            o.setSucesso(true);
            
        } catch (SQLException ex) {
            o.addMensagem("Inserção mal sucedida em Pessoas_Desaparecidas.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }

        return o;
    }

}
