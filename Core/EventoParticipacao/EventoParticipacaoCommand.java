package EventoParticipacao;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Domain.EventoParticipacao;
import src.Global;
import src.Inicio;


public class EventoParticipacaoCommand {
	public EventoParticipacaoHandler handler;
	public List<EventoParticipacao> eventosParticipacao;
	
	public EventoParticipacaoCommand() {
		handler = new EventoParticipacaoHandler();
		eventosParticipacao = new ArrayList<EventoParticipacao>();
	}
	public boolean ParticiparEvento(int idEvento) throws IOException, ParseException {
		eventosParticipacao = handler.GetListParticipacao();
		
		if(eventosParticipacao == null)
			eventosParticipacao = new ArrayList<EventoParticipacao>();
		
		EventoParticipacao Novo = new EventoParticipacao();
		Novo.SetId(ObterNovoIdParticipacao());
		Novo.SetidEvento(idEvento);
		Novo.SetidUsuario(Global.idUsuario);
		
		eventosParticipacao.add(Novo);
		
		boolean salvou = handler.CreateEventoParticipacao(eventosParticipacao);
		
		System.out.println("Participação confirmada!");
		
		Inicio.MenuOpcoes();
		
		return salvou;
		
	}
	
	
	public int ObterNovoIdParticipacao() {
		if(eventosParticipacao == null)
			return 1;
		return (int)eventosParticipacao.stream().count() + 1;
	}
}
