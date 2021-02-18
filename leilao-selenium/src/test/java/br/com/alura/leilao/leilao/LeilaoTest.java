/**
 * 
 */
package br.com.alura.leilao.leilao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

/**
 * @author andersonnogueira
 * @since Feb 16, 2021
 */

public class LeilaoTest {

	private LeilaoPage paginaDeLeilao;


	@AfterEach
	public void afterEach() {
		this.paginaDeLeilao.fechar();
	}
	
	
	@Test
	public void deveriaCadastrarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeilao = paginaDeLogin.efetuarLogin();
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeilao.carregarFormulario();
	}
}
