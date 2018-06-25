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
            st = c.prepareStatement("INSERT INTO Pessoas_Desaparecidas (RG, CPF, nome, inserido_por, atualizado_por) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, p.getRG());
            st.setString(2, p.getCPF());
            st.setString(3, p.getNome());            
            st.setInt(4, p.getInserido_por());
            st.setInt(5, p.getAtualizado_por());
            

            st.executeUpdate();

            o.setSucesso(true);
            o.addMensagem("Sucesso ao inserir pessoa desaparecida no banco de dados.\n");
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao inserir pessoa desaparecida do banco de dados.\n");
        }
        Conexao.encerrarConexao(c, st);

        return o;
    }
    
     public Operacao remover(String cpf){
        
        Operacao o = new Operacao();
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("DELETE FROM pessoas_desaparecidas WHERE cpf = ?");
            st.setString(1, cpf);
            
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
                p.setCPF(rs.getString("CPF"));
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
        Conexao.encerrarConexao(c, st, rs);
        return o;
    }
     
    public Operacao getPessoa(String cpf){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();

        try{
            st = c.prepareStatement("SELECT * FROM Pessoas_Desaparecidas WHERE cpf = ?");
            st.setString(1, cpf);
            Pessoa_Desaparecida p = new Pessoa_Desaparecida();

            rs = st.executeQuery();

            if(rs.next()){
                p.setId(rs.getInt("id"));
                p.setCPF(rs.getString("cpf"));
                p.setRG(rs.getString("rg"));
                p.setNome(rs.getString("nome"));
                p.setUltimo_local(rs.getInt("ultimo_local"));
                p.setInserido_por(rs.getInt("inserido_por"));
                p.setAtualizado_por(rs.getInt("atualizado_por"));
                o.setDado(p);
            }
            o.setSucesso(true);


        }catch(SQLException ex){
            o.addMensagem("Falha ao buscar na tabela Pessoas_Desaparecidas.");
        }
        Conexao.encerrarConexao(c, st, rs);
        return o;

    }
     
     public Operacao atualizar(String cpf, int id_localizacao){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();

        try {
            st = c.prepareStatement("UPDATE Pessoas_Desaparecidas SET ultimo_local = ? WHERE cpf = ?");
            st.setInt(1, id_localizacao);
            st.setString(2, cpf);

            st.executeUpdate();

            o.setSucesso(true);
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao atualizar pessoa desaparecida no banco de dados.\n");
        }
        Conexao.encerrarConexao(c, st);

        return o;
    }

}
