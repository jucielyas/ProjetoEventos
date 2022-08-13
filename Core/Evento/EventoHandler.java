package Evento;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import DataIntegration.TxtService;

public class EventoHandler {
	private TxtService txtService;
	private String entidade = "Evento.data.txt";
	private Gson objJson = new Gson();
	
	public EventoHandler() {
		txtService = new TxtService(entidade);
	}
	public boolean Create(List<Domain.Evento> lista) throws IOException {
		
		String json = objJson.toJson(lista);
		boolean salvou = txtService.GravarArquivo(json);
		
		return salvou;
	}
	
	public List<Domain.Evento> GetList() throws IOException {	
		
		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Domain.Evento>>(){}.getType();
		List<Domain.Evento> lista = new Gson().fromJson(json, listType);
		
		return lista;
	}
	

}
