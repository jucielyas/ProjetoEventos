package Domain;

public class Endereco extends Base {
	public String Rua;
	public String Bairro;
	public String Cidade;
	public String Estado;
	public int Numero;
	
	
	public void SetRua(String Rua) {
	    this.Rua = Rua;
	  }
	
	public void SetBairro(String Bairro) {
	    this.Bairro = Bairro;	  
	  }
	public void SetCidade(String Cidade) {
	    this.Cidade = Cidade;
	  }
	
	public void SetEstado(String Estado) {
	    this.Estado = Estado;	  
	  }
	public void SetNumero(int Numero) {
	    this.Numero = Numero;	  
	  }
	
	
	public String GetRua() {
	    return this.Rua;
	  }
	
	public String GetBairro() {
	    return this.Bairro;  
	  }
	
	public String GetCidade() {
	    return this.Cidade;
	  }
	
	public String GetEstado() {
	    return this.Estado;  
	  }
	
	public int GetNumero() {
	    return this.Numero;  
	  }
}
