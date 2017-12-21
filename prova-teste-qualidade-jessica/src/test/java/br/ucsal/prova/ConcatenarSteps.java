package br.ucsal.prova;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConcatenarSteps {

	private WebDriver navegador;
	
	@Given("estou na tela de concatenação")
	public void concatenarDoisNomes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\100912556\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.get(
				"file:///C:/Users/100912556/workspace/prova-teste-qualidade-jessica/src/test/java/br/ucsal/prova/index.html");
		
//		obterNomes(navegador);
//		concatenarNomes(navegador);
//		exibirNomesTest(navegador);
//		navegador.quit();
	}

	@When("Informo o prenome $prenome")
	public void obterPrenome(String prenome) {

		navegador.findElement(By.id("nome")).sendKeys(prenome);
	}

	@When("Informo o sobrenome $sobrenome")
	public void obterSobrenome(String sobrenome) {

		navegador.findElement(By.id("sobrenome")).sendKeys(sobrenome);
	}

	@Then("solicito a concatenação dos nomes")
	public void concatenarNomes() {
		navegador.findElement(By.id("botao")).click();
	}

	@Then("é exibido o nome $nomeCompleto")
	public void exibirNomesTest(String nomeCompleto) {
		String nomeAtual = navegador.findElement(By.id("nomeSobrenome")).getText();

		Assert.assertEquals(nomeCompleto, nomeAtual);
	}

}
