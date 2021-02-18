/**
 * 
 */
package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author andersonnogueira
 * @since Feb 17, 2021
 */
public class LeilaoPage {
	
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private ChromeDriver browser;

	public LeilaoPage( ChromeDriver browser) {
		this.browser = browser;
	}

	public void fechar() {
		browser.quit();
	}

	
	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);
	}

	/**
	 * @param nome
	 * @param valorInicial
	 * @param dataAbertura
	 * @return
	 */
	public boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
		
		WebElement ultimaLinhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		
		WebElement colunaNome = ultimaLinhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = ultimaLinhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = ultimaLinhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome)
				&& colunaDataAbertura.getText().equals(dataAbertura)
				&& colunaValorInicial.getText().equals(valorInicial);
	}


	
	
	
	

}
