package buscarUsuarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class BuscarUsuarios {
	
	static WebDriver driver;
	static String pathDriver="./src/test/resources/chrome/chromedriver.exe";
	static String tipoDriver="webdriver.chrome.driver";

	@Before
	public void setUp() throws Exception {
	System.setProperty(tipoDriver, pathDriver);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	@After
	public void tearDown() throws Exception {
	if (driver != null)
	driver.quit();	
	}
	
	@Given("ya que estoy autenticado")
	public void ya_que_estoy_autenticado() {
		
		driver.get("http://localhost/control/login.php");
		
		driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
		driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys("admin");
		
		//llenar campo contraseña
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys("admin");
		
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Given("estoy en la pagina usuarios {string}")
	public void estoy_en_la_pagina_usuarios(String string) {
	    driver.get(string);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	}

	@Given("existen usuarios registrados")
	public void existen_usuarios_registrados() {
	}
	
	@When("el usuario ingresa un {string} en el buscador {string}")
	public void el_usuario_ingresa_un_en_el_buscador(String string, String string2) {
		
		driver.findElement(By.xpath(string2)).click();
	    driver.findElement(By.xpath(string2)).clear();
	    driver.findElement(By.xpath(string2)).sendKeys(string);
    
	}

	@When("presione el boton buscar")
	public void presione_el_boton_buscar() {
	   driver.findElement(By.xpath("//*[@id=\"datos_cotizacion\"]/div/div[2]/button")).click();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("el sistema debe mostrar a los usuarios con ese nombre")
	public void el_sistema_debe_mostrar_a_los_usuarios_con_ese_nombre() {
		String xpath = "/html/body/div[1]/div/div[2]/div[5]/div/table/tbody/tr[2]/td[2]";
		
		WebElement user = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(user.isDisplayed());
		String userText = user.getText();
		Assert.assertTrue(userText.contains("Duoc"));
	}
	
}