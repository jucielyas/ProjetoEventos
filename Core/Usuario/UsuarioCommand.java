package Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Domain.EventoParticipacao;
import Domain.Usuario;
import src.Global;
import src.Inicio;
import Utils.Helpers;
import Utils.MenuOpcoes;

public class UsuarioCommand {
	
	public UsuarioHandler handler;
	public List<Usuario> usuarios;
	public UsuarioCommand() {
		handler = new UsuarioHandler();
		usuarios = new ArrayList<Usuario>();
	}
	
	public void FormUsuario() throws IOException, ParseException {
	
		usuarios = handler.GetList();
		if(usuarios == null)
			usuarios = new ArrayList<Usuario>();
		
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		
		Domain.Usuario NovoUsuario = new Domain.Usuario();
		
		System.out.println("--------- Cadastro de Usuário ---------- ");
		System.out.println("Digite o nome:");
		NovoUsuario.SetNome(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("Digite a idade:");
		NovoUsuario.SetIdade(Integer.parseInt(opcaoEscolhidaMenu.nextLine()));
		
		System.out.println("Digite o Email:");
		NovoUsuario.SetEmail(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("Digite a Senha:");
		NovoUsuario.SetSenha(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("-");
		NovoUsuario.SetId(ObterNovoId());
		
		usuarios.add(NovoUsuario);
		
		boolean salvou = handler.Create(usuarios);
		
		if(salvou)
			System.out.println("Usuário salvo com sucesso!");
		else
			System.out.println("Ocorreu um erro ao tentar salvar usuário!");
		
			
		Inicio.MenuOpcoes();
		
	}
	
	public void Login() throws IOException, ParseException  {
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		String opcaoEscolhida = "";
		int idUsuario = 0;
		
		usuarios = handler.GetList();
		
		do {
		
		System.out.println("--------- Faça seu login ou digite W para se cadastrar ---------- ");
		
		System.out.println("Email:");
		String email = opcaoEscolhidaMenu.nextLine();
		
		if(email.toLowerCase().equals("w"))
			new UsuarioCommand().FormUsuario();		
		
		System.out.println("Senha:");
		String senha = opcaoEscolhidaMenu.nextLine();
		
		usuarios = handler.GetList();
		List<Usuario> usuarioExistente = usuarios.stream()
			     .filter(item -> item.GetEmail().equals(email) && item.GetSenha().equals(senha)).toList();
		
		if(usuarioExistente.size() > 0)
			idUsuario = usuarioExistente.get(0).id; 
		else
			System.out.println("Email ou Senha incorretos. Por favor, tente novamente.");
			     
		}while(idUsuario == 0);
		
		Global.idUsuario = idUsuario;
	

	
	}
	
	public int ObterNovoId() {
		if(usuarios == null)
			return 1;
		return (int)usuarios.stream().count() + 1;
	}
	
	
}
