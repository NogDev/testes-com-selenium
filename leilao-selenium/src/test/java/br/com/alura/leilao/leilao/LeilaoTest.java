/**
 * 
 */
package br.com.alura.leilao.leilao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		//Entering the Cadastro page
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeilao = paginaDeLogin.efetuarLogin();
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeilao.carregarFormulario();
		
		//Registering an Leilão
		String dataAbertura = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilão do dia " + dataAbertura;
		String valorInicial = "500.00";
		
		
		//Switching to the Leilões listing page
		this.paginaDeLeilao = paginaDeCadastro.cadastrarLeilao(nome, valorInicial, dataAbertura);
		
		assertTrue(paginaDeLeilao.isLeilaoCadastrado(nome, valorInicial, dataAbertura));
	}
}
