package dao;

import modelo.Usuario_Tipo;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Operacao;


public class Usuario_TipoDAO {
    
    //Não vamos utilizar isso
    public void inserir(Usuario_Tipo t){
        
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        
        try {
            st = c.prepareStatement("INSERT INTO Usuario_Tipos (nome, descricao) VALUES (?, ?)");
            st.setString(1, t.getNome());
            st.setString(2, t.getDescricao());
            
            st.executeUpdate();
            
            System.out.println("Inserção bem sucedida em Usuario_Tipos.");
        } catch (SQLException ex) {
            System.out.println("Inserção mal sucedida em Usuario_Tipos.");
        }finally{
            Conexao.encerrarConexao(c, st);
        }
    }
    
    //Talvez essa função seja dispensável
    public Operacao nomeTipo(int tipo){
        Connection c = Conexao.estabelecerConexao();
        PreparedStatement st = null;
        ResultSet rs = null;
        
        Operacao o = new Operacao();
        String nome = "";
        
        try{
            st = c.prepareStatement("SELECT nome FROM Usuario_Tipos WHERE id = " + tipo);
            
            rs = st.executeQuery();
            if(rs.next()){
                nome = rs.getString("nome");
                o.setDado(nome);
            }

            o.setSucesso(true);
            
        } catch (SQLException ex) {
            o.addMensagem("Erro ao buscar o tipo " + tipo + ".\n");
        }
        finally{
            Conexao.encerrarConexao(c, st);
        }
        
        return o;
    }
 } 

