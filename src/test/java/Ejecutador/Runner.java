package Ejecutador;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={
		"./src/test/resources/BuscarCategoria.feature",
		"./src/test/resources/BuscarInventario.feature",
		"./src/test/resources/CrearCategoria.feature",
		"./src/test/resources/escenariosBuscarUsuarios.feature",
		"./src/test/resources/escenariosInicioSesion.feature",
		"./src/test/resources/escenariosRegistroUsuarios.feature"
}, glue= {
		"buscarCategoria",
		"BuscarInventario",
		"CrearCategoria",
		"buscarUsuarios",
		"inicioDeSesion",
		"registroUsuarios"},
		plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"
        })
public class Runner {
	
}
