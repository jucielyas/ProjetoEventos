package Categoria;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Domain.Categoria;
import src.Inicio;

public class CategoriaCommand {
	public CategoriaHandler handler;
	public List<Categoria> categorias;
	public CategoriaCommand() {
		handler = new CategoriaHandler();
		categorias = new ArrayList<Categoria>();
	}
	
	public void FormCategoria() throws IOException, ParseException {
	
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		
		categorias = handler.GetList();
		
		Domain.Categoria Novo = new Domain.Categoria();
		
		System.out.println("--------- Cadastro de Categorias ---------- ");
		System.out.println("Digite a descricao:");
		Novo.SetDescricao(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("-");
		
		Novo.SetId(ObterNovoId());
		categorias.add(Novo);
		
		boolean salvou = handler.Create(categorias);
		
		if(salvou)
			System.out.println("Categoria salva com sucesso!");
		else
			System.out.println("Ocorreu um erro ao tentar salvar Categoria!");
		
			
		Inicio.MenuOpcoes();
		
	}
	
	public int EscolherCategoria() throws IOException {
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		int idCategoriaEscolhida = 0;
		categorias = handler.GetList();
		
		System.out.println("Escolha a Categoria:");
		
		for (int i=0; i<(int)categorias.stream().count(); i++) 
		{ 		
			int idCategoria = categorias.get(i).GetId();
			System.out.println(idCategoria + " - "+ categorias.get(i).GetDescricao());		 
		}
		
		idCategoriaEscolhida = Integer.parseInt(opcaoEscolhidaMenu.nextLine());
		
		return idCategoriaEscolhida;
	}
	
	public int ObterNovoId() {
		if(categorias == null)
			return 1;
		return (int)categorias.stream().count() + 1;
	}
	
}
