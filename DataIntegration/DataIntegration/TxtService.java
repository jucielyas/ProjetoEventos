package DataIntegration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtService {

	private File file = new File("");
	private String CaminhoArquivo = "";
	
	public TxtService(String entidade) {
		CaminhoArquivo = file.getAbsoluteFile().toString()+ "\\ProjetoEventos\\Data\\"+entidade;
	}
	
	public boolean GravarArquivo(String json) throws IOException {
		File fileEntidade = new File(CaminhoArquivo);
		FileWriter arq = new FileWriter(fileEntidade);
	 	
	    arq.write("");
	    arq.flush();
	    
	    arq.write(json);
	    arq.flush();
	    
	    arq.close();
	    
	    return true;
	}
	
	public String ObterLeituraArquivo() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(CaminhoArquivo))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String retorno = sb.toString();
		    
		    return retorno;
		}
	}
	
}
