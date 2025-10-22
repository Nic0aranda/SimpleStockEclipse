package InicioDeSesion;

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
	
	@Given("dado que el usuario ya se encuentra en la cuenta admin")
	public void dado_que_el_usuario_ya_se_encuentra_en_la_cuenta_admin() {
		driver.get("http://localhost/control/login.php?logout");
		
		
        driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
        driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys("admin");

        //llenar campo contraseña
        driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
        driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys("admin");
        
        //boton iniciar sesion
        driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("el usuario se dirige a usuarios")
	public void el_usuario_se_dirige_a_usuarios() {
	    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[3]")).click();
	}

	@Given("el usuario presiona el boton nuevo usuario")
	public void el_usuario_presiona_el_boton_nuevo_usuario() {
	    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div")).click();
	}

	@Given("el usuario llena los campos y presiona el boton guardar datos {string} {string}")
	public void el_usuario_llena_los_campos_y_presiona_el_boton_guardar_datos(String string, String string2) {
		
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(string);
		
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("pascal");
		
		driver.findElement(By.xpath("//*[@id=\"user_name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user_name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys(string);
		
		driver.findElement(By.xpath("//*[@id=\"user_email\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user_email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("juanito.pong@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"user_password_new\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user_password_new\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user_password_new\"]")).sendKeys(string2);
		
		driver.findElement(By.xpath("//*[@id=\"user_password_repeat\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user_password_repeat\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user_password_repeat\"]")).sendKeys(string2);
		
		driver.findElement(By.xpath("//*[@id=\"guardar_datos\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("el usuario presiona el boton salir")
	public void el_usuario_presiona_el_boton_salir() {
	    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li")).click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Then("deberias estar en la pagina inicial")
	public void deberias_estar_en_la_pagina_inicial() {
		String xpath = "/html/body/nav/div/div[1]";
		
		WebElement text = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(text.isDisplayed());
		String iniText = text.getText();
		Assert.assertTrue(iniText.contains("Inventario"));
	}
}
