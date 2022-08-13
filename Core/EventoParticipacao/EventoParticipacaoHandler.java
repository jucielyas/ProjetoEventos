package EventoParticipacao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataIntegration.TxtService;

public class EventoParticipacaoHandler {
	private TxtService txtService;
	private String entidade = "EventoParticipacao.data.txt";
	private Gson objJson = new Gson();
	
	public EventoParticipacaoHandler() {
		txtService = new TxtService(entidade);
	}
	
	public boolean CreateEventoParticipacao(List<Domain.EventoParticipacao> lista) throws IOException {
		
		String json = objJson.toJson(lista);
		boolean salvou = txtService.GravarArquivo(json);
		
		return salvou;
	}
	
	public List<Domain.EventoParticipacao> GetListParticipacao() throws IOException {	
		
		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Domain.EventoParticipacao>>(){}.getType();
		List<Domain.EventoParticipacao> lista = new Gson().fromJson(json, listType);
		
		return lista;
	}
}
