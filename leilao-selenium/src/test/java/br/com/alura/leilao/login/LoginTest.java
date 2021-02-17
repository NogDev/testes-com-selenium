/**
 * 
 */
package br.com.alura.leilao.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author andersonnogueira
 * @since Feb 16, 2021
 */

public class LoginTest {
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver browser = new ChromeDriver();	
		
		browser.navigate().to("http://localhost:8080/login");
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-form")).submit();
		
		assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
		
		browser.quit();

	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver browser = new ChromeDriver();	
		
		browser.navigate().to("http://localhost:8080/login");
		browser.findElement(By.id("username")).sendKeys("invalido");
		browser.findElement(By.id("password")).sendKeys("q12312312");
		browser.findElement(By.id("login-form")).submit();
		
		assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));

		
		browser.quit();
		
	}

}
