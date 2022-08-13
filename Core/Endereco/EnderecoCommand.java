package Endereco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Categoria.CategoriaHandler;
import Domain.Categoria;
import Domain.Endereco;
import src.Inicio;

public class EnderecoCommand {
	public EnderecoHandler handler;
	public List<Endereco> enderecos;
	
	public EnderecoCommand() {
		handler = new EnderecoHandler();
		enderecos = new ArrayList<Endereco>();
	}
	
	public int FormEndereco() throws IOException {
		Scanner opcaoEscolhidaMenu = new Scanner(System.in);
		Domain.Endereco Novo = new Domain.Endereco();	
		
		enderecos = handler.GetList();
		if(enderecos == null)
			enderecos = new ArrayList<Endereco>();
		
		System.out.println("Informe o endereço do evento:");
		
		System.out.println("Cidade:");
		Novo.SetCidade(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("Estado:");
		Novo.SetEstado(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("Rua:");
		Novo.SetRua(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("Bairro:");
		Novo.SetBairro(opcaoEscolhidaMenu.nextLine());
		
		System.out.println("Número:");
		Novo.SetNumero(Integer.parseInt(opcaoEscolhidaMenu.nextLine()));
		
		System.out.println("-");
		Novo.SetId(ObterNovoId());
		
		enderecos.add(Novo);
		
		boolean salvou = handler.Create(enderecos);
		
		if(!salvou)
			System.out.println("Ocorreu um erro ao tentar salvar Endereço!");
		
		return Novo.GetId();
	}
	

	
	
	public int ObterNovoId() {
		if(enderecos == null)
			return 1;
		return (int)enderecos.stream().count() + 1;
	}
	
}
