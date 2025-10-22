package Ejecutador;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"./src/test/resources/Features/escenariosInicioSesion.feature",
		"./src/test/resources/Features/escenariosBuscarUsuarios.feature",
		"./src/test/resources/Features/BuscarCatergoria.feature",
		"./src/test/resources/Features/escenariosRegistroUsuarios.feature"
}, glue= {"InicioDeSesion",
		"BuscarUsuarios",
		"buscarCategoria",
		"RegistroUsuarios"})
public class Runner {

}
