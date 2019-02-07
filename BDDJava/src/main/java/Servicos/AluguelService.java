package Servicos;

import Entidades.Filme;
import Entidades.NotaAluguel;
import Entidades.TipoAluguel;
import Utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Filme sem estoque!");

		NotaAluguel nota = new NotaAluguel();
		switch (tipo) {
		case COMUM:
			nota.setPreco(filme.getAluguel());
			nota.setDataEntrega(DateUtils.obterDataDiferenciadaDias(1));
			nota.setPontuacao(1);
			break;
		case EXTENDIDO:
			nota.setPreco(filme.getAluguel() * 2);
			nota.setDataEntrega(DateUtils.obterDataDiferenciadaDias(3));
			nota.setPontuacao(2);
			break;
			
		case SEMANAL:
			nota.setPreco(filme.getAluguel() * 3);
			nota.setDataEntrega(DateUtils.obterDataDiferenciadaDias(7));
			nota.setPontuacao(3);
			break;
			
		}

		filme.setEstoque(filme.getEstoque() - 1); // desincrementar o estoque
		return nota;

	}

}
