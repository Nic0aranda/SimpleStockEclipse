package InicioDeSesion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class InicioSesion {
	
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
	
	//Escenario Inicio de sesión funciona correctamente
	
	@Given("al navegar a la pagina de inicio de sesion {string}")
	public void al_navegar_a_la_pagina_de_inicio_de_sesion(String string) {
		
		driver.get("http://localhost/control/login.php?logout");
		
	}

	@Given("el usuario tiene una cuenta existente")
	public void el_usuario_tiene_una_cuenta_existente() {	
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("coloca en el campo Usuario {string} y en campo contraseña {string}")
	public void coloca_en_el_campo_usuario_y_en_campo_contraseña(String string, String string2) {
	    
		//llenar campo usuario
		driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
		driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys(string);
		
		//llenar campo contraseña
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys(string2);
		
	}

	@When("hacer click en el boton Iniciar sesion")
	public void hacer_click_en_el_boton_iniciar_sesion() {
	    driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	}

	@Then("te rediriges a la pagina {string}")
	public void te_rediriges_a_la_pagina(String string) {
		String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(string, currentUrl);
	}
	
}
