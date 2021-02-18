/**
 * 
 */
package br.com.alura.leilao.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author andersonnogueira
 * @since Feb 16, 2021
 */

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		
		
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuarLogin();
		
		assertFalse(paginaDeLogin.isPaginaDeLogin());
		assertEquals("fulano", paginaDeLogin.getUsuarioLogado());

	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.preencheFormularioDeLogin("fulano1231", "pass31231");
		paginaDeLogin.efetuarLogin();
		
		assertTrue(paginaDeLogin.isPaginaDeErroDeLogin());
		assertNull("fulano", paginaDeLogin.getUsuarioLogado());
		assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	public void naoDeveriaAcessarAreaRestritaSemEstatLogado() {
		paginaDeLogin.navegaParaPaginaDeLances();
		
		assertTrue(paginaDeLogin.isPaginaDeLogin());
		assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}

}
