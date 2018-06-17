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


public class ApelidosDAO {
    
    public Operacao inserir(Apelido a){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        Operacao o = new Operacao();

        try {
            st = c.prepareStatement("INSERT INTO Apelidos (id_pessoa, apelido) VALUES (?, ?)");
            st.setInt(1, a.getId_pessoa());
            st.setString(2, a.getApelido());

            st.executeUpdate();

            o.setSucesso(true);
            o.addMensagem("Sucesso ao inserir apelido no banco de dados.\n");
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao inserir apelido do banco de dados.\n");
        }
        Conexao.encerrarConexao(c, st);

        return o;
    }
    
     public Operacao remover(int id){
        
        Operacao o = new Operacao();
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("DELETE FROM Apelidos WHERE id = ?");
            st.setInt(1, id);
            
            st.executeUpdate();
            o.addMensagem("Sucesso ao remover apelido.\n");
            
            o.setSucesso(true);
        } catch (SQLException ex) {
            o.addMensagem("Erro ao remover apelido.\n");
        }
        Conexao.encerrarConexao(c, st);
        
        return o;
    }
     
     public Operacao listar(int id_pessoa){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<Apelido> apelidos = null;
        
        try{
            apelidos = new ArrayList<>();
            st = c.prepareStatement("SELECT * FROM denuncias WHERE id_pessoa = ?");
            st.setInt(1, id_pessoa);
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Apelido a = new Apelido();
                d.setId(rs.getInt("id"));
                d.setId_usuario(rs.getInt("id_usuario"));
                d.setTelefone(rs.getString("telefone"));
                d.setLocal_ligacao(rs.getString("local_ligacao"));
                
                denuncias.add(d);
            }
            o.setDado(denuncias);
            o.setSucesso(true);
                        
        }catch(SQLException ex){
            o.addMensagem("Falha ao buscar na tabela Denuncias.\n");
        }
        return o;
    }


    
}
