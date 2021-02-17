/**
 * 
 */
package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author andersonnogueira
 * @since Feb 16, 2021
 */
public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		
		// para dar permissão de escrita: chmod +x chromedriver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver browser = new ChromeDriver();	
		
		browser.navigate().to("http://localhost:8080/");
		browser.quit();
	}
}
