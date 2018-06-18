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


public class DenunciasDAO {

    public Operacao inserir(Denuncia d){

        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        ResultSet rs = null;
        Operacao o = new Operacao();
        int id = 0;

        try {
            st = c.prepareStatement("INSERT INTO Denuncias (id_usuario, telefone, local_ligacao) VALUES (?, ?, ?) RETURNING id");
            st.setInt(1, d.getId_usuario());
            st.setString(2, d.getTelefone());
            st.setString(3, d.getLocal_ligacao());

//            st.executeUpdate();;
            rs = st.executeQuery();
            if(rs.next()){
                id = rs.getInt("id");
            }
            o.setDado(id);

            o.setSucesso(true);
            o.addMensagem("Sucesso ao inserir denúncia no banco de dados.\n");
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao inserir denúncia do banco de dados.\n");
        }
        Conexao.encerrarConexao(c, st);

        return o;
    }
    
     public Operacao remover(int id){
        
        Operacao o = new Operacao();
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("DELETE FROM Denuncias WHERE id = ?");
            st.setInt(1, id);
            
            st.executeUpdate();
            o.addMensagem("Sucesso ao remover denúncia.\n");
            
            o.setSucesso(true);
        } catch (SQLException ex) {
            o.addMensagem("Erro ao remover denúncia.\n");
        }
        Conexao.encerrarConexao(c, st);
        
        return o;
    }
     
     public Operacao listar(){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null; 
        ResultSet rs = null;

        Operacao o = new Operacao();
        List<Denuncia> denuncias = null;
        
        try{
            denuncias = new ArrayList<>();
            st = c.prepareStatement("SELECT * FROM denuncias");
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Denuncia d = new Denuncia();
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
