package Domain;
import java.util.Date;

public class Evento  extends Base  {
	public int idCategoria;
	public int idEndereco;
	public String nome;
	public Date  data;
	public String descricao;
	
	
	public void SetIdCategoria(int idCategoria) {
	    this.idCategoria = idCategoria;
	  }
	
	public void SetIdEndereco(int idEndereco) {
	    this.idEndereco = idEndereco;	  
	  }
	public void SetNome(String nome) {
	    this.nome = nome;
	  }
	
	public void SetData(Date data) {
	    this.data = data;	  
	  }
	public void SetDescricao(String descricao) {
	    this.descricao = descricao;
	  }
	
	
	
	public int GetIdCategoria() {
	    return this.idCategoria;
	  }
	
	public int GetIdEndereco() {
	    return this.idEndereco;  
	  }
	public String GetNome() {
	    return this.nome;
	  }
	
	public Date GetData() {
	    return this.data;  
	  }
	public String GetDescricao() {
	    return this.descricao;
	  }

}
