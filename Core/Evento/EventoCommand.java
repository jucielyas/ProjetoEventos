package Evento;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Categoria.CategoriaCommand;
import Categoria.CategoriaHandler;
import Domain.Categoria;
import Domain.Endereco;
import Domain.Evento;
import Domain.EventoParticipacao;
import Domain.Usuario;
import Endereco.EnderecoCommand;
import Endereco.EnderecoHandler;
import EventoParticipacao.EventoParticipacaoCommand;
import EventoParticipacao.EventoParticipacaoHandler;
import src.Global;
import src.Inicio;

public class EventoCommand {
	private EventoHandler handler;
	private CategoriaHandler handlerCategoria;
	private EnderecoHandler handlerEndereco;
	private EventoParticipacaoHandler handlerEventoParticipacao;
	
	private CategoriaCommand commandCategoria;
	private EnderecoCommand commandEndereco;
	private EventoParticipacaoCommand commandEvendoParticipacao;
	
	private List<Evento> eventos;
	private List<Categoria> categorias;
	private List<Endereco> enderecos;
	private List<EventoParticipacao> eventoParticipacao;
	
	public EventoCommand() {
		handler = new EventoHandler();	
		handlerCategoria = new CategoriaHandler();
		handlerEndereco = new EnderecoHandler();
		handlerEventoParticipacao = new EventoParticipacaoHandler();
		
		commandCategoria = new CategoriaCommand();
		commandEndereco = new EnderecoCommand();
		commandEvendoParticipacao = new EventoParticipacaoCommand();
		
		eventoParticipacao = new ArrayList<EventoParticipacao>();
		eventos = new ArrayList<Evento>();
		enderecos = new ArrayList<Endereco>();
		categorias = new ArrayList<Categoria>();
	}
	
	public void FormEvento() throws IOException, ParseException {
	
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		
		eventos = handler.GetList();		
		
		Domain.Evento Novo = new Domain.Evento();
		
		System.out.println("--------- Cadastro de Evento ---------- ");
		
		System.out.println("Nome do evento: ");
		Novo.SetNome(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("Data do evento:  (Por favor escrever no formato dd/MM/yyyy)");
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(opcaoEscolhidaMenu.nextLine());  
		Novo.SetData(data);
		
		System.out.println("Descrição do evento: ");
		Novo.SetDescricao(opcaoEscolhidaMenu.nextLine());
		
		int idCategoriaEscolhida = commandCategoria.EscolherCategoria();	
		int idEndereco = commandEndereco.FormEndereco();
		
		System.out.println("-");
		
		Novo.SetIdCategoria(idCategoriaEscolhida);
		Novo.SetIdEndereco(idEndereco);
		Novo.SetId(ObterNovoId());
		eventos.add(Novo);
		
		boolean salvou = handler.Create(eventos);
		
		if(salvou)
			System.out.println("Evento salvo com sucesso!");
		else
			System.out.println("Ocorreu um erro ao tentar salvar Evento!");
		
			
		Inicio.MenuOpcoes();
		
	}
	
	public int EscolherEvento() throws IOException, ParseException {
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		int idEventoEscolhido = 0;
		eventos = handler.GetList();
		
		if(eventos == null)
			eventos = new ArrayList<Evento>();
		
		String RespostaParticipacao = "Não";
	 
		
		System.out.println("Escolha o Evento que deseja participar:");
		
		do {
			System.out.println("0 - Voltar ao menu principal");
			
			for (int i=0; i<(int)eventos.stream().count(); i++) 
			{ 		
				int idEvento = eventos.get(i).GetId();
				String descEvento = eventos.get(i).GetDescricao();
				System.out.println(idEvento + " - "+ descEvento);		 
			}
						
			idEventoEscolhido = Integer.parseInt(opcaoEscolhidaMenu.nextLine());
			if(idEventoEscolhido == 0)
				Inicio.MenuOpcoes();
			
			int idEscolhido = idEventoEscolhido;
			
			System.out.println("-");
			System.out.println("-");
			
			Evento result = eventos.stream()
				     .filter(item -> item.GetId() == idEscolhido).toList().get(0);
			
			enderecos = handlerEndereco.GetList();
			Endereco endereco = enderecos.stream()
				     .filter(item -> item.GetId() == result.idEndereco).toList().get(0);
			
			categorias = handlerCategoria.GetList();
			Categoria categoria = categorias.stream()
				     .filter(item -> item.GetId() == result.idCategoria).toList().get(0);
			
			System.out.println("Informações do evento:");
			System.out.println(result.nome);
			System.out.println(result.descricao);
			System.out.println(result.data);
			
			System.out.println("Endereço do evento:");
			System.out.println(endereco.Rua+", "+endereco.Numero + ", "+ endereco.Bairro +" - "+ endereco.Cidade+" - "+ endereco.Estado);
			
			System.out.println("Categoria do evento:");
			System.out.println(categoria.descricao);
			
			System.out.println("-");
			System.out.println("-");
			System.out.println("-");
			System.out.println("-");
			System.out.println("-");
			
			System.out.println("Deseja participar deste evento? Responda apenas com Sim ou Não");
			
			RespostaParticipacao = opcaoEscolhidaMenu.nextLine();
				
		}while(!RespostaParticipacao.toLowerCase().equals("sim"));
		
		commandEvendoParticipacao.ParticiparEvento(idEventoEscolhido);
		
		return idEventoEscolhido;
	}
	

	public void ListaEventosPorIdUsuario() throws IOException, ParseException {
		
		eventoParticipacao = handlerEventoParticipacao.GetListParticipacao();
		eventos = handler.GetList();
		
		if(eventoParticipacao == null)
			eventoParticipacao = new ArrayList<EventoParticipacao>();
		
		if(eventos == null)
			eventos = new ArrayList<Evento>();
		
		eventoParticipacao = eventoParticipacao.stream()
			     .filter(item -> item.GetidUsuario() == Global.idUsuario && !item.participacaoCancelada).toList();
		
		List<Evento> eventosPorUsuario = new ArrayList<Evento>();
		
		for (int i=0; i<(int)eventoParticipacao.stream().count(); i++) 
		{ 		
			int idEvento = eventoParticipacao.get(i).GetidEvento();
			var existeEvento = eventos.stream()
				     .filter(item -> item.GetId() == idEvento).toList();	
			
			if(existeEvento != null)
			{
				var evento = existeEvento.get(0);
				eventosPorUsuario.add(evento);
			}
		}
		
		
		System.out.println("-------- Meus Eventos ----------");
		
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		
		for (int i=0; i<(int)eventosPorUsuario.stream().count(); i++) 
		{ 		
			int idEvento = eventosPorUsuario.get(i).GetId();
			String descEvento = eventosPorUsuario.get(i).GetDescricao();
			String dataEvento = eventosPorUsuario.get(i).GetData().toString();
			System.out.println(idEvento + " - "+ descEvento + " - " + dataEvento);		 
		}
		
		System.out.println("Deseja cancelar a participação em algum evento? Digite o número. Ou aperte X para sair.");
		
		if(opcaoEscolhidaMenu.nextLine().toLowerCase().equals("x"))
			Inicio.MenuOpcoes();
	
		
		
	}
	

	
	public int ObterNovoId() {
		if(eventos == null)
			return 1;
		return (int)eventos.stream().count() + 1;
	}

	
}
