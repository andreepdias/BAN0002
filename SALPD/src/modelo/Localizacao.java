package modelo;


public class Localizacao {
    
    private  int id;
    private int id_pessoa;
    private int id_denuncia;
    private String local;
    private String data;
    private String hora;

    public Localizacao() {
    }

    public Localizacao(int id_pessoa, int id_denuncia, String local, String data, String hora) {
        this.id_pessoa = id_pessoa;
        this.id_denuncia = id_denuncia;
        this.local = local;
        this.data = data;
        this.hora = hora;
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

    public int getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(int id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
       
    
}