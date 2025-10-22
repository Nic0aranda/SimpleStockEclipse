package buscarCategoria;

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
	
	
	
	@Given("ya que estoy autenticado")
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
	
	@Given("me encuentro en la pagina {string}")
	public void te_rediriges_a_la_pagina(String string) {
		String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(string, currentUrl);
	}
	
}
