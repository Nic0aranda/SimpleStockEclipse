package buscarCategoria;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class buscarCategoria {

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
	
	
	
	@Given("una vez autenticado")
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
	
	@Given("hay categorias existentes")
	public void hay_categorias_existentes() {
	}
	
	@When("presiono el boton {string}")
	public void presiono_el_boton(String string) {
		driver.findElement(By.xpath(string)).click();
	}

	@When("selecciono una de las opciones disponibles en {string}")
	public void selecciono_una_de_las_opciones_disponibles_en(String string) {
		driver.findElement(By.xpath(string)).click();
	}

	@Then("aparece un producto en la lista {string}")
	public void aparece_un_producto_en_la_lista(String string) {
		WebElement objeto = driver.findElement(By.xpath(string));
		Assert.assertTrue(objeto.isDisplayed());
        String userText = objeto.getText();
        Assert.assertTrue(userText.contains("Martillo"));
	}
	
	@When("presiono el buscador {string}")
	public void presiono_el_buscador(String string) {
		driver.findElement(By.xpath(string)).click();
	}

	@When("escribo la descripcion de la categoria")
	public void escribo_la_descripcion_de_la_categoria() {
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("herramienta clava clavos");
	}
	
	@When("escribo la fecha de agregado de un producto")
	public void escribo_la_fecha_de_agregado_de_un_producto() {
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("20/09/2021");
	}
	
	@Then("no aparecen productos {string}")
	public void no_aparecen_productos(String xpath) {
	    List<WebElement> elementos = driver.findElements(By.xpath(xpath));
	    // Verifica que no hay elementos visibles
	    Assert.assertTrue("Se encontraron productos, pero no deberían aparecer.",
	                      elementos.isEmpty());
	}
	
}
