package EventoParticipacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Domain.EventoParticipacao;
import src.Global;


public class EventoParticipacaoCommand {
	public EventoParticipacaoHandler handler;
	public List<EventoParticipacao> eventosParticipacao;
	
	public EventoParticipacaoCommand() {
		handler = new EventoParticipacaoHandler();
		eventosParticipacao = new ArrayList<EventoParticipacao>();
	}
	public boolean ParticiparEvento(int idEvento) throws IOException {
		eventosParticipacao = handler.GetListParticipacao();
		
		if(eventosParticipacao == null)
			eventosParticipacao = new ArrayList<EventoParticipacao>();
		
		EventoParticipacao Novo = new EventoParticipacao();
		Novo.id = ObterNovoIdParticipacao();
		Novo.idEvento = idEvento;
		Novo.idUsuario = Global.idUsuario;
		
		eventosParticipacao.add(Novo);
		
		boolean salvou = handler.CreateEventoParticipacao(eventosParticipacao);
		
		System.out.println("Participação confirmada!");
		
		return salvou;
		
	}
	
	
	public int ObterNovoIdParticipacao() {
		if(eventosParticipacao == null)
			return 1;
		return (int)eventosParticipacao.stream().count() + 1;
	}
}
