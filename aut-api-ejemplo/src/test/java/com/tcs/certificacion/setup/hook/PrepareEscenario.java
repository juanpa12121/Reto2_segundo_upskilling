package com.tcs.certificacion.setup.hook;

import com.tcs.certificacion.enums.Environment;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class PrepareEscenario {
    private EnvironmentVariables environmentVariables;
    private String ambient;
    @Before
    public void prepararEscenarios() {
        ambient = environmentVariables.optionalProperty("amb").orElse("https://reqres.in");
        setTheStage(new OnlineCast());
        theActor("Administrador")
                .whoCan(CallAnApi.at(Environment.getEnvironment(ambient)));
    }
}
