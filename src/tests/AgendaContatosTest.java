package tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgendaContatosTest {

	@Test
	public void test() {

		//definindo o local do driver para o googledriver
		System.setProperty("webdriver.chrome.driver", "c:\\chrome\\chromedriver.exe");
		
		//Abrindo o googlechrome
		WebDriver driver = new ChromeDriver();
 
		//maximizando a janela do navegador
		driver.manage().window().maximize();
		
		//acessar a p�gina de cadastro de conta de usu�rio
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/Account/Register");
		
		//preenchendo o nome do usu�rio
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Sergio Mendes");
		
		//preenchendo o email do usu�rio
		int random = new Random().nextInt(999999);
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("sergio.coti"+ random +"@gmail.com");
		
		//preenchendo a senha do usu�rio
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("@Admin123");
		
		//preenchendo a confirma��o da senha do usu�rio
		driver.findElement(By.xpath("//*[@id=\"SenhaConfirmacao\"]")).sendKeys("@Admin123");
		
		//clicando no bot�o de cadastro
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form/div[5]/input")).click();
		
		//ler a mensagem obtida
		String mensagem = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[2]/strong")).getText();
		
		//comparando o resultado esperado X resultado obtido
		assertEquals(mensagem, "Parab�ns Sergio Mendes, sua conta foi cadastrada com sucesso!");
		
		//fechar o navegador
		driver.close();
		driver.quit();
	}
}






