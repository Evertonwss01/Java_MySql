import java.util.Date;    

public abstract class Generica {
	
	// Atributos //
    private int id;
    private String nome;
    private Date dataRegistro;

    // Metodos Especiais //
    public int getId(){
        return id;
    }public void setId(int id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }public void setNome(String nome){
        this.nome = nome;
    }
    public Date getDataRegistro(){
        return dataRegistro;
    }public void setDataRegistro(Date da) {
    	this.dataRegistro = da;
    }
}
