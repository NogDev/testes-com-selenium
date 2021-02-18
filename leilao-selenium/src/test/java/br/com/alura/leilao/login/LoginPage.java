/**
 * 
 */
package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leilao.LeilaoPage;

/**
 * @author andersonnogueira
 * @since Feb 17, 2021
 */
public class LoginPage extends PageObject{
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {	
		super(null);
		this.browser.navigate().to(URL_LOGIN);
		
	}	

	public void preencheFormularioDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}


	public LeilaoPage efetuarLogin() {
		browser.findElement(By.id("login-form")).submit();	
		
		return new LeilaoPage(browser);
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
	public boolean isPaginaDeErroDeLogin() {
		
		return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
	}


	public String getUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
			
		} catch (NoSuchElementException e) {
			return null;
		}
	}


	public void navegaParaPaginaDeLances() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

}
