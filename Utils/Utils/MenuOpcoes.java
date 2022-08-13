package Utils;
import java.util.stream.*;

public enum MenuOpcoes {
	CadastroUsuario(1), CadastroEvento(2), CadastroCategoriaEvento(3), ConsultaEventos(4), MeusEventos(5);
	
	private final int valor;
	MenuOpcoes(int valorOpcao){
	valor = valorOpcao;
	}
	public int getValor(){
	return valor;
	}
	
	public static Stream<MenuOpcoes> stream() {
        return Stream.of(MenuOpcoes.values()); 
    }
	
}
