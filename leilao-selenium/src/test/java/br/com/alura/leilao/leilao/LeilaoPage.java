/**
 * 
 */
package br.com.alura.leilao.leilao;

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
	
	
	
	

}
