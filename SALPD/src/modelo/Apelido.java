package modelo;


public class Apelido {
    
    private  int id;
    private int id_pessoa;
    private String apelido;

    public Apelido() {
    }

    public Apelido(int id_pessoa, String apelido) {
        this.id_pessoa = id_pessoa;
        this.apelido = apelido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    
    
    
}
