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
}
