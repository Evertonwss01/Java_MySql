import java.util.Date;    

public abstract class Generica {
	
	// Atributos //
    private int id;
    private String uuid;
    private Date dataRegistro;

    // Metodos Especiais //
    public int getId(){
        return id;
    }public void setId(int id){
        this.id = id;
    }
    public String getUuid(){
        return uuid;
    }public void setUuid(String uuid){
        this.uuid = uuid;
    }
    public Date getDataRegistro(){
        return dataRegistro;
    }public void setDataRegistro(Date da) {
    	this.dataRegistro = da;
    }
}
