package Domain;

public class Usuario extends Base{
	private String nome;
	private int idade;
	private String email;
	private String senha;
	
	public void SetNome(String nome) {
	    this.nome = nome;
	  }
	
	public void SetIdade(int idade) {
	    this.idade = idade;	  
	  }
	
	public String GetNome() {
	    return this.nome;
	  }
	
	public int GetIdade() {
	    return this.idade;  
	  }
	
	public void SetEmail(String email) {
	    this.email = email;
	  }
	
	public void SetSenha(String senha) {
	    this.senha = senha;	  
	  }
	
	public String GetEmail() {
	    return this.email;
	  }
	
	public String GetSenha() {
	    return this.senha;  
	  }
}
