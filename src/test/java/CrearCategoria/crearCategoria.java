package CrearCategoria;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class crearCategoria {
	
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
	
	
	@Given("dado el usuario en la cuenta admin")
	public void dado_el_usuario_en_la_cuenta_admin() {
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

	@Given("presiona el boton categorias {string}")
	public void presiona_el_boton_categorias(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	
	
	
	@Given("presiona el boton nueva categoria {string}")
	public void presiona_el_boton_nueva_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	

	@When("coloca un nombre de categoria {string}")
	public void coloca_un_nombre_de_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("Taladro");
	}
	
	@When("coloca solo un nombre de categoria {string}")
	public void coloca_solo_un_nombre_de_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("PruebaSoloNombre");
	}

	@When("coloca una descripcion de categoria {string}")
	public void coloca_una_descripcion_de_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("Bauker 13mm 900W 220V");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("coloca solo descripcion de categoria {string}")
	public void coloca_solo_descripcion_de_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.findElement(By.xpath(string)).clear();
		driver.findElement(By.xpath(string)).sendKeys("Solo descripcion categoria");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@When("apreta el boton guardar categoria {string}")
	public void apreta_el_boton_guardar_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("cierra la ventana de agregar categoria {string}")
	public void cierra_la_ventana_de_agregar_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("la categoria deberia verse en la tabla categorias")
	public void la_categoria_deberia_verse_en_la_tabla_categorias() {
		String xpath = "/html/body/div[1]/div";
		
		WebElement user = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(user.isDisplayed());
		String userText = user.getText();
		Assert.assertTrue(userText.contains("Taladro"));
	}
	
	@Then("la categoria solo nombre deberia verse en la tabla categorias")
	public void la_categoria_solo_nombre_deberia_verse_en_la_tabla_categorias() {
		String xpath = "/html/body/div[1]/div";
		
		WebElement user = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(user.isDisplayed());
		String userText = user.getText();
		Assert.assertTrue(userText.contains("PruebaSoloNombre"));
	}
	
	
	@Then("categoria no esta en la lista")
	public void categoria_no_esta_en_la_lista() {
String xpath = "/html/body/div[1]/div";
		
		WebElement user = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(user.isDisplayed());
		String userText = user.getText();
		Assert.assertFalse(userText.contains("Bauker 13mm 900W 220V"));
	}
	
}
