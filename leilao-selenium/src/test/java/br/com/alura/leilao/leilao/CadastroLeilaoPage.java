/**
 * 
 */
package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author andersonnogueira
 * @since Feb 17, 2021
 */
public class CadastroLeilaoPage {
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	
	private ChromeDriver browser;

	public CadastroLeilaoPage( ChromeDriver browser) {
		this.browser = browser;
	}

	public void fechar() {
		browser.quit();
	}

	/**
	 * @param Nome do leilão
	 * @param Valor inicial 
	 * @param Data de Abertura
	 */
	public LeilaoPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
		this.browser.findElement(By.id("button-submit")).submit();
		
		return new LeilaoPage(browser);
	}
	
	public boolean isPaginaAtual() {
		
		return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
	}

	/**
	 * @return
	 */
	public boolean isMensagensDeValidacaoVisiveis() {
		String pageSource = browser.getPageSource();
		return pageSource.contains("não deve estar em branco")
				&& pageSource.contains("minimo 3 caracteres")
				&& pageSource.contains("deve ser um valor maior de 0.1")
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
}
