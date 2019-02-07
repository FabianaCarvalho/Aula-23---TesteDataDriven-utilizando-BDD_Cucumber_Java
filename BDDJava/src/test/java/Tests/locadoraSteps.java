package Tests;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import Entidades.Filme;
import Entidades.NotaAluguel;
import Entidades.TipoAluguel;
import Servicos.AluguelService;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class locadoraSteps {

	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		filme = new Filme(); // inicializar o filme
		filme.setEstoque(arg1); // relacionado ao estoque

	}

	@Dado("^que o preço do aluguel seja R\\$(\\d+)$")
	public void queOPreçoDoAluguelSejaR$(int arg1) throws Throwable {
		filme.setAluguel(arg1);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			// System.out.println(nota);
			nota = aluguel.alugar(filme, tipoAluguel);
			// System.out.println(nota);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Então("^o preço do aluguel será de R\\$(\\d+)$")
	public void oPreçoDoAluguelSeráDeR$(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPreco());
	}

	@Então("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		Date dataRetorno = nota.getDataEntrega();
		Calendar calRetorno = Calendar.getInstance();
		calRetorno.setTime(dataRetorno);

		Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
		Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));

	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
		Assert.assertEquals(arg1, filme.getEstoque());
	}

	@Então("^não será possivel por falta de estoque$")
	public void não_será_possivel_por_falta_de_estoque() throws Throwable {
		Assert.assertEquals("Filme sem estoque!", erro);
	}

//cenário 3

	@Dado("^um filme com o estoque de (\\d+) unidades$")
	public void um_filme_com_o_estoque_de_unidades(int arg1) throws Throwable {

	}

	@Dado("^que o preço de aluguel seja de (\\d+)$")
	public void que_o_preço_de_aluguel_seja_de(int arg1) throws Throwable {

	}

	@Dado("^que o tipo de alguel seja extendido$")
	public void que_o_tipo_de_alguel_seja_extendido() throws Throwable {

	}

	@Então("^o preço do aluguel será (\\d+)$")
	public void o_preço_do_aluguel_será(int arg1) throws Throwable {

	}

	@Então("^a data de entrega será em (\\d+)$")
	public void a_data_de_entrega_será_em(int arg1) throws Throwable {

	}

	@Então("^a pontuação recebida será de (\\d+) pontos$")
	public void a_pontuação_recebida_será_de_pontos(int arg1) throws Throwable {

	}

	@Dado("^que o tipo de alguel seja comum$")
	public void que_o_tipo_de_alguel_seja_comum() throws Throwable {

	}

	@Dado("^que o tipo de alguel seja semanal$")
	public void que_o_tipo_de_alguel_seja_semanal() throws Throwable {

	}

}
