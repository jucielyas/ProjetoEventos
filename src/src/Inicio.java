package src;
import Usuario.UsuarioCommand;
import Utils.Helpers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Categoria.CategoriaCommand;
import Evento.EventoCommand;

public class Inicio {

	public static void main(String[] args) throws IOException, ParseException {
		
		try {
	
			MenuOpcoes();
		    
		}
		catch(IOException ex) {
			System.out.println("Ocorreu uma falha ao validar informações. Por favor, tente novamente.");
			MenuOpcoes();
		}
	}

	public static int MenuOpcoes() throws IOException, ParseException {
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		String opcaoEscolhida = "";
		int opcao = 0;
		try {
		if(Global.idUsuario == 0)
			new UsuarioCommand().Login();
		}catch(IOException ex) {
			System.out.println("Ocorreu uma falha ao validar informações. Por favor, tente novamente.");
			MenuOpcoes();
		}
		do {
		
		System.out.println("--------- Escolha uma opção e digite o número ---------- ");
		System.out.println(Utils.MenuOpcoes.CadastroEvento.getValor() + " - Cadastro de Evento");
		System.out.println(Utils.MenuOpcoes.CadastroCategoriaEvento.getValor() + " - Cadastro categoria Eventos");
		System.out.println(Utils.MenuOpcoes.ConsultaEventos.getValor() + " - Consulta de Eventos");
		System.out.println(Utils.MenuOpcoes.MeusEventos.getValor() + " - Meus eventos");
		
		opcaoEscolhida = opcaoEscolhidaMenu.nextLine();
		String numeroEscolhido = opcaoEscolhida;
		
		opcao = (int)Utils.MenuOpcoes.stream()
        .filter(d -> Integer.toString(d.getValor()).equals(numeroEscolhido)).count();
		
		}while(!Helpers.isNumeric(opcaoEscolhida) || opcao == 0);
		
		var opcaoEscolha = Integer.parseInt(opcaoEscolhida);
	    
	    if(opcaoEscolha == Utils.MenuOpcoes.CadastroUsuario.getValor())
	    	new UsuarioCommand().FormUsuario();
	    if(opcaoEscolha == Utils.MenuOpcoes.CadastroCategoriaEvento.getValor())
	    	new CategoriaCommand().FormCategoria();
	    if(opcaoEscolha == Utils.MenuOpcoes.CadastroEvento.getValor())
	    	new EventoCommand().FormEvento();
	    if(opcaoEscolha == Utils.MenuOpcoes.ConsultaEventos.getValor())
	    	new EventoCommand().EscolherEvento();

		return opcaoEscolha;
	}
	

	
}

