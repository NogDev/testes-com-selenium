/**
 * 
 */
package br.com.alura.leilao.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author andersonnogueira
 * @since Feb 16, 2021
 */

public class LoginTest {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private ChromeDriver browser;
	
	
	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	}

	@BeforeEach
	public void beforeEach() {
		this.browser = new ChromeDriver();	
		browser.navigate().to(URL_LOGIN);
	}
	
	@AfterEach
	public void afterEach() {
		browser.quit();
	}
	
	
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		
		
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-form")).submit();
		
		assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());

	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		
		browser.findElement(By.id("username")).sendKeys("invalido");
		browser.findElement(By.id("password")).sendKeys("q12312312");
		browser.findElement(By.id("login-form")).submit();
		
		assertTrue(browser.getCurrentUrl().equals(URL_LOGIN + "?error"));
		assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
	}

}
