public class Artigo extends Generica{

	// Atributos //
    public int user_id;
    public String titulo;
    public String resumo;
    public String texto;
    public String slug;

    // Metodos Espsciais //

    public int getUser_id(){
        return user_id;
    }public void setUser_id(int user){
        this.user_id = user;
    }
    public String getTitulo(){
        return titulo;
    }public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getResumo(){
        return resumo;
    }public void setResumo(String resu){
        this.resumo = resu;
    }
    public String getTexto(){
        return texto;
    }public void setTexto(String tex){
        this.texto = tex;
    }
    public String getSlug(){
        return slug;
    }public void setSlug(String slu){
        this.slug = slu;
    }
}
