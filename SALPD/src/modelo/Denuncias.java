package modelo;


public class Denuncias {
    
    private  int id;
    private int id_usuario;
    private String telefone;
    private String local_ligacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLocal_ligacao() {
        return local_ligacao;
    }

    public void setLocal_ligacao(String local_ligacao) {
        this.local_ligacao = local_ligacao;
    }
    
}
