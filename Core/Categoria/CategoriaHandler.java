package Categoria;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataIntegration.TxtService;

public class CategoriaHandler {
	public TxtService txtService;
	private String entidade = "Categorias.data.txt";
	private Gson objJson = new Gson();
	
	public CategoriaHandler() {
		txtService = new TxtService(entidade);
	}
	public boolean Create(List<Domain.Categoria> lista) throws IOException {
		
		String json = objJson.toJson(lista);
		boolean salvou = txtService.GravarArquivo(json);
		
		return salvou;
	}
	
	public List<Domain.Categoria> GetList() throws IOException {
		
		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Domain.Categoria>>(){}.getType();
		List<Domain.Categoria> lista = new Gson().fromJson(json, listType);
		
		return lista;
	}
}
