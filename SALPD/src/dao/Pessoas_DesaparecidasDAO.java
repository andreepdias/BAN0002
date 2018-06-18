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


public class Pessoas_DesaparecidasDAO {

    public Operacao inserir(Pessoa_Desaparecida p){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();

        try {
            st = c.prepareStatement("INSERT INTO Pessoas_Desaparecidas (RG, nome, inserido_por, atualizado_por) VALUES (?, ?, ?, ?)");
            st.setString(1, p.getRG());
            st.setString(2, p.getNome());
            st.setInt(3, p.getInserido_por());
            st.setInt(4, p.getAtualizado_por());
            

            st.executeUpdate();

            o.setSucesso(true);
            o.addMensagem("Sucesso ao inserir pessoa desaparecida no banco de dados.\n");
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao inserir pessoa desaparecida do banco de dados.\n");
        }
        Conexao.encerrarConexao(c, st);

        return o;
    }
    
     public Operacao remover(int id){
        
        Operacao o = new Operacao();
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("DELETE FROM pessoas_desaparecidas WHERE id = ?");
            st.setInt(1, id);
            
            st.executeUpdate();
            o.addMensagem("Sucesso ao remover pessoa desaparecida.\n");
            
            o.setSucesso(true);
        } catch (SQLException ex) {
            o.addMensagem("Erro ao remover pessoa desaparecida.\n");
        }
        Conexao.encerrarConexao(c, st);
        
        return o;
    }
     
     public Operacao listar(){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<Pessoa_Desaparecida> pessoas = null;
        
        try{
            pessoas = new ArrayList<>();
            st = c.prepareStatement("SELECT * FROM Pessoas_Desaparecidas");
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Pessoa_Desaparecida p = new Pessoa_Desaparecida();
                p.setId(rs.getInt("id"));
                p.setRG(rs.getString("RG"));
                p.setNome(rs.getString("nome"));
                p.setUltimo_local(rs.getInt("ultimo_local"));
                p.setInserido_por(rs.getInt("inserido_por"));
                p.setAtualizado_por(rs.getInt("atualizado_por"));
                
                pessoas.add(p);
            }
            o.setDado(pessoas);
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao buscar na tabela Usuarios.");
        }
        return o;
    }
     
     public Operacao atualizar(int id_pessoa, int id_localizacao){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();

        try {
            st = c.prepareStatement("UPDATE Pessoas_Desaparecidas SET ultimo_local = ? WHERE id = ?");
            st.setInt(1, id_localizacao);
            st.setInt(2, id_pessoa);

            st.executeUpdate();

            o.setSucesso(true);
            o.addMensagem("Sucesso ao atualizar pessoa desaparecida no banco de dados.\n");
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao atualizar pessoa desaparecida do banco de dados.\n");
        }
        Conexao.encerrarConexao(c, st);

        return o;
    }

}
