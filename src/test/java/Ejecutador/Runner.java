package Ejecutador;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"./src/test/resources/Features/escenariosInicioSesion.feature","./src/test/resources/Features/BuscarCategoria.feature" }, glue= {"InicioDeSesion", "buscarCategoria"})
public class Runner {
 
}
