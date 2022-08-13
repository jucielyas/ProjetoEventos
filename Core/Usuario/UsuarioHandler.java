package Usuario;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataIntegration.*;

public class UsuarioHandler {
	
	private TxtService txtService;
	private Gson objJson = new Gson();
	private String entidade = "Usuarios.data.txt";
	
	public UsuarioHandler() {
		txtService = new TxtService(entidade);
	}
	public boolean Create(List<Domain.Usuario> usuario) throws IOException {
		
		String jsonUsuario = objJson.toJson(usuario);
		boolean salvou = txtService.GravarArquivo(jsonUsuario);
		
		return salvou;
	}
	
	public List<Domain.Usuario> GetList() throws IOException {	
		
		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Domain.Usuario>>(){}.getType();
		List<Domain.Usuario> lista = new Gson().fromJson(json, listType);
		
		return lista;
	}
}
