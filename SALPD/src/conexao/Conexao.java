package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://pellefant.db.elephantsql.com:5432/fhoodbzu";
    private static final String USUARIO = "fhoodbzu";
    private static final String SENHA = "4UUU3h8KIhSB0PmJ-O9tl3DiWIs2cRIy";
    
    public static Connection estabelecerConexao(){
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USUARIO, SENHA);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao estabelecer conexão: ", ex);
        }
    }
    
    public static void encerrarConexao(Connection c){
        if(c != null){
            try {
                c.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao encerrar conexão: ", ex);
            }
        }
    }
    public static void encerrarConexao(Connection c, PreparedStatement st){
        encerrarConexao(c);
        
        if(st != null){
            try {
                st.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao encerrar conexão: ", ex);
            }
        }
    }
    public static void encerrarConexao(Connection c, PreparedStatement st, ResultSet rs){
        encerrarConexao(c, st);
        
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao encerrar conexão: ", ex);
            }
        }
    }
    
}
