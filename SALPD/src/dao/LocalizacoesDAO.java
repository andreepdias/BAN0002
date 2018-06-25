package dao;

import modelo.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Operacao;


public class LocalizacoesDAO {

    public Operacao inserir(Localizacao l){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        ResultSet rs = null;
        Operacao o = new Operacao();
        int id = 0;

        try {
//            st = c.prepareStatement("INSERT INTO Localizacoes (id_pessoa, id_denuncia, local, data, hora) VALUES (?, ?, ?, ?, ?)");
            st = c.prepareStatement("INSERT INTO Localizacoes (id_pessoa, id_denuncia, local, data, hora) VALUES (?, ?, ?, '" + l.getData() + "', '" + l.getHora() + "') RETURNING id");
            st.setInt(1, l.getId_pessoa());
            st.setInt(2, l.getId_denuncia());
            st.setString(3, l.getLocal());
//            st.setString(4, l.getData());
//            st.setString(5, l.getHora());
//            st.executeUpdate();
            rs = st.executeQuery();
            if(rs.next()){
                id = rs.getInt("id");
            }
            o.setDado(id);
            o.setSucesso(true);    
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao inserir uma nova localização do banco de dados.\n");
        }
        Conexao.encerrarConexao(c, st);

        return o;
    }
    
     public Operacao remover(int id){
        
        Operacao o = new Operacao();
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("DELETE FROM Localizacoes WHERE id_denuncia = ?");
            st.setInt(1, id);
            
            st.executeUpdate();
            o.addMensagem("Sucesso ao remover uma localização.\n");
            
            o.setSucesso(true);
        } catch (SQLException ex) {
            o.addMensagem("Erro ao remover uma localização.\n");
        }
        Conexao.encerrarConexao(c, st);
        
        return o;
    }
     
     public Operacao listar(int id_pessoa){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<Localizacao> localizacoes = null;
        
        try{
            localizacoes = new ArrayList<>();
            st = c.prepareStatement("SELECT * FROM localizacoes WHERE id_pessoa = ?");
            st.setInt(1, id_pessoa);
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Localizacao l = new Localizacao();
                l.setId(rs.getInt("id"));
                l.setId_pessoa(rs.getInt("id_pessoa"));
                l.setId_denuncia(rs.getInt("id_denuncia"));
                l.setLocal(rs.getString("local"));
                l.setData(rs.getString("data"));
                l.setHora(rs.getString("hora"));
                
                localizacoes.add(l);
            }
            o.setDado(localizacoes);
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao buscar na tabela Localizações.\n");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o;
    }

}
