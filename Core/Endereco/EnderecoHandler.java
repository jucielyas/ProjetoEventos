package Endereco;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataIntegration.TxtService;

public class EnderecoHandler {
	public TxtService txtService;
	private String entidade = "Enderecos.data.txt";
	private Gson objJson = new Gson();
	
	public EnderecoHandler() {
		txtService = new TxtService(entidade);
	}
	public boolean Create(List<Domain.Endereco> lista) throws IOException {
		
		String json = objJson.toJson(lista);
		boolean salvou = txtService.GravarArquivo(json);
		
		return salvou;
	}
	
	public List<Domain.Endereco> GetList() throws IOException {

		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Domain.Endereco>>(){}.getType();
		List<Domain.Endereco> lista = new Gson().fromJson(json, listType);
		
		return lista;
	}
}
