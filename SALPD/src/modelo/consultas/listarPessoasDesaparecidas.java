package modelo.consultas;


public class listarPessoasDesaparecidas {
    
    private  int id;
    private String RG;
    private String nome;
    private int ultimo_local;
    private int inserido_por;
    private int atualizado_por;

    public listarPessoasDesaparecidas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUltimo_local() {
        return ultimo_local;
    }

    public void setUltimo_local(int ultimo_local) {
        this.ultimo_local = ultimo_local;
    }

    public int getInserido_por() {
        return inserido_por;
    }

    public void setInserido_por(int inserido_por) {
        this.inserido_por = inserido_por;
    }

    public int getAtualizado_por() {
        return atualizado_por;
    }

    public void setAtualizado_por(int atualizado_por) {
        this.atualizado_por = atualizado_por;
    }
    
    
}
