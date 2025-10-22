package BuscarInventario;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.WebElement;

public class buscarInventario {

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
	
	
	
	@Given("ya autenticado")
    public void ya_que_estoy_autenticado() {
		
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
	
	@Given("hay productos existentes")
	public void hay_categorias_existentes() {
	}
	

	@Then("aparecen productos en la lista {string}")
	public void aparece_producto_en_la_lista(String string) {
		WebElement objeto = driver.findElement(By.xpath(string));
		Assert.assertTrue(objeto.isDisplayed());
        String userText = objeto.getText();
        Assert.assertTrue(userText.contains("Martillo"));
	}
	
	@When("hago click en el buscador {string}")
	public void hago_click_en_el_buscador(String string) {
		driver.findElement(By.xpath(string)).click();
	}

	@When("escribo el nombre del producto")
	public void escribo_el_nombre_del_producto() {
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("martillo");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("escribo parte del nombre del producto")
	public void escribo_parte_del_nombre_del_producto() {
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("mart");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("escribo el ID del producto")
	public void escribo_el_ID_del_producto() {
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("M001");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("presiono el boton categoria {string}")
	public void presiono_el_boton_categoria(String string) {
		driver.findElement(By.xpath(string)).click();
	}
	
	@When("selecciono una de las opciones disponibles {string}")
	public void selecciono_una_de_las_opciones_disponibles(String string) {
		driver.findElement(By.xpath(string)).click();
	}
	
	@When("selecciono una de las opciones disponibles incorrecta {string}")
	public void selecciono_una_de_las_opciones_disponibles_incorrecta(String string) {
		driver.findElement(By.xpath(string)).click();
	}
	
	@Then("no aparecen productos en lista {string}")
	public void no_aparecen_productos_en_lista(String xpath) {
	    List<WebElement> elementos = driver.findElements(By.xpath(xpath));
	    // Verifica que no hay elementos visibles
	    Assert.assertTrue("Se encontraron productos, pero no deberían aparecer.",
	                      elementos.isEmpty());
	}
	
}