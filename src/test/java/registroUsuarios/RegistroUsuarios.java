package registroUsuarios;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RegistroUsuarios {
	
	static WebDriver driver;
	static String pathDriver="./src/test/resources/chrome/chromedriver.exe";
	static String tipoDriver="webdriver.chrome.driver";
	
	@Before
	public void setUp() throws Exception {
	System.setProperty(tipoDriver, pathDriver);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	}


	@After
	public void tearDown() throws Exception {
	if (driver != null)
	driver.quit();
	}
	
	
	@Given("dado que el usuario se encuentra en la cuenta admin")
	public void dado_que_el_usuario_se_encuentra_en_la_cuenta_admin() {
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

	@Given("se encuentra en la pagina usuarios {string}")
	public void se_encuentra_en_la_pagina_usuarios(String string) {
		driver.get(string);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("presiona el boton {string}")
	public void presiona_el_boton(String string) {
		driver.findElement(By.xpath(string)).click();
	}

	@When("coloca un nombre valido en {string}")
	public void coloca_un_nombre_valido_en(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("pedro");
	}

	@When("coloca un apellido valido en {string}")
	public void coloca_un_apellido_valido_en(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("pascal");
	}

	@When("coloca un usuario valido en {string}")
	public void coloca_un_usuario_valido_en(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("pedro69");
	}

	@When("coloca un email valido en {string}")
	public void coloca_un_email_valido_en(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("pedro.pascal@gmail.com");
	}

	@When("coloca una contraseña valida {string}")
	public void coloca_una_contraseña_valida(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("colocoloGB");
	}

	@When("coloca denuevo la contraseña {string}")
	public void coloca_denuevo_la_contraseña(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("colocoloGB");
	}

	@When("apreta el boton {string}")
	public void apreta_el_boton(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("el usuario nuevo se veria en la tabla de usuarios")
	public void el_usuario_nuevo_se_veria_en_la_tabla_de_usuarios() {
		String xpath = "/html/body/div[1]/div/div[2]/div[5]/div/table/tbody";
		
		WebElement user = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(user.isDisplayed());
		String userText = user.getText();
		Assert.assertTrue(userText.contains("pedro"));
	}
	
	@Then("el usuario nuevo no se veria en la tabla de usuarios")
	public void el_usuario_nuevo_no_se_veria_en_la_tabla_de_usuarios() {
		String xpath = "/html/body/div[1]/div/div[2]/div[5]/div/table";
		
		WebElement user = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(user.isDisplayed());
		String userText = user.getText();
		Assert.assertFalse(userText.contains("pedro"));
	}
	
	@When("coloca una contraseña no valida {string}")
	public void coloca_una_contraseña_no_valida(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("123");
	}
	
	@When("coloca denuevo la contraseña equivocada{string}")
	public void coloca_denuevo_la_contraseña_equivocada(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("123");
	}

	@Then("deberia de verse un mensaje de error")
	public void deberia_de_verse_un_mensaje_de_error() {
	    
	}
	
	@Then("el sistma muestra un mensaje indicando que no deben existir datos vacios")
	public void el_sistma_muestra_un_mensaje_indicando_que_no_deben_existir_datos_vacios() {

	}
}
