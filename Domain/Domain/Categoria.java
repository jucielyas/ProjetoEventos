package Domain;

public class Categoria extends Base {
	public String descricao;
	
	public void SetDescricao(String descricao) {
	    this.descricao = descricao;
	  }
	
	
	public String GetDescricao() {
	    return this.descricao;  
	  }
}
