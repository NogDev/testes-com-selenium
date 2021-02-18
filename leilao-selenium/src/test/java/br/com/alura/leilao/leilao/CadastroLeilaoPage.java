/**
 * 
 */
package br.com.alura.leilao.leilao;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author andersonnogueira
 * @since Feb 17, 2021
 */
public class CadastroLeilaoPage {
	
	private ChromeDriver browser;

	public CadastroLeilaoPage( ChromeDriver browser) {
		this.browser = browser;
	}

	public void fechar() {
		browser.quit();
	}
}
