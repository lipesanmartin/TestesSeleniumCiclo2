package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutosPO extends BasePO{

	@FindBy(className = "nav-link")
	public WebElement buttonVoltar;
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonAdicionar;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(id = "cadastro-produto")
	public WebElement modalProduto;
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "mensagem")
	public WebElement spanMensagem;
	
	@FindBy(id="data")
	public WebElement inputData;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[1]")
	public WebElement codigoSalvo;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[2]")
	public WebElement nomeSalvo;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[3]")
	public WebElement quantidadeSalvo;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[4]")
	public WebElement valorSalvo;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[5]")
	public WebElement dataSalvo;
	
	public ProdutosPO(WebDriver driver) {
		super(driver);
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public void clicarEmVoltar() {
		buttonVoltar.click();
	}
	
	public void abrirModal() {
		buttonAdicionar.click();
		buttonAdicionar.click();
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	

}
