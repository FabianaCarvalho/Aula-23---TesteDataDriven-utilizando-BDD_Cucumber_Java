package Entidades;

public class Filme {
	private int estoque; // armazenar a variavel do estoque
	private int aluguel; // armazenar a variavel do aluguel

	public void setEstoque(int arg1) {
		this.estoque = arg1; // e o estoque ira receber o valor dentro do arg1
	}

	public void setAluguel(int arg1) {
		this.aluguel = arg1;
		
	}
	
	public int getAluguel() {
		return aluguel;
	}

	public int getEstoque() {
		return estoque;
	}

}
