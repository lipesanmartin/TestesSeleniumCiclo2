package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.ProdutosPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutosTest extends BaseTest {

	private static ProdutosPO produtosPage;

	@BeforeClass
	public static void prepararTestes() {
		produtosPage = new ProdutosPO(driver);
	}

	@Test
	public void TC001_cadastrarCamposErrados() {

		produtosPage.abrirModal();

		produtosPage.inputCodigo.sendKeys("123abc");
		produtosPage.inputNome.sendKeys("123abc");
		produtosPage.inputValor.sendKeys("123abc");
		produtosPage.inputQuantidade.sendKeys("123abc");
		produtosPage.inputData.sendKeys("123abc");

		produtosPage.buttonSalvar.click();

		String mensagem = produtosPage.obterMensagem();
		assertEquals(mensagem, "Erro ao cadastrar produto");
	}

	@Test
	public void TC002_cadastrarProduto() {

		produtosPage.abrirModal();
		produtosPage.escrever(produtosPage.inputCodigo, "1234");
		produtosPage.escrever(produtosPage.inputNome, "Teste Produto");
		produtosPage.escrever(produtosPage.inputQuantidade, "123");
		produtosPage.escrever(produtosPage.inputValor, "12.34");
		produtosPage.escrever(produtosPage.inputData, "22051992");

		produtosPage.buttonSalvar.click();

		assertEquals(produtosPage.codigoSalvo.getText(), "1234");
		assertEquals(produtosPage.nomeSalvo.getText(), "Teste Produto");
		assertEquals(produtosPage.valorSalvo.getText(), "12.34");
		assertEquals(produtosPage.quantidadeSalvo.getText(), "123");
		assertEquals(produtosPage.dataSalvo.getText(), "1992-05-22");

	}

	@Test
	public void TC003_cadastrarProdutoFaltandoCampos() {

		produtosPage.abrirModal();

		produtosPage.escrever(produtosPage.inputCodigo, "1");
		produtosPage.escrever(produtosPage.inputNome, "Produto 1");
		produtosPage.escrever(produtosPage.inputQuantidade, "7");
		produtosPage.buttonSalvar.click();

		String mensagem = produtosPage.obterMensagem();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

}
