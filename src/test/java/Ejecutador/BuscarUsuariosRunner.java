package Ejecutador;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"./src/test/resources/Features/escenariosBuscarUsuarios.feature"}, glue= {"BuscarUsuarios"})

public class BuscarUsuariosRunner {

}
