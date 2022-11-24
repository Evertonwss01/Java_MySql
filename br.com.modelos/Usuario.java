
public class Usuario extends Generica{

	// Atributos Usuario //
    private String login;
    private String senha;

    // Metodos Especiais //
    public String getLogin(){
        return login;
    }public void setLogin(String lo){
        this.login = lo;
    }
    public String getSenha(){
        return senha;
    }public void setSenha(String sen){
        this.senha = sen;
    }
}
