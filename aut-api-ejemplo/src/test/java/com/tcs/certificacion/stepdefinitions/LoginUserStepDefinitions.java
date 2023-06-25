package com.tcs.certificacion.stepdefinitions;

import com.tcs.certificacion.exceptions.GeneralExceptions;
import com.tcs.certificacion.models.User;
import com.tcs.certificacion.questions.ValidateStatusCode;
import com.tcs.certificacion.questions.ValidateToken;
import com.tcs.certificacion.tasks.LoginUser;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import java.util.Map;

import static com.tcs.certificacion.enums.Constants.EMAIL;
import static com.tcs.certificacion.enums.Constants.PASSWORD;
import static com.tcs.certificacion.exceptions.GeneralExceptions.USER_NOT_FOUND;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginUserStepDefinitions {
//    @Given("I can query the reqres.in api")
//    public void iCanQueryTheReqresInApi() {
//
//    }

    @DataTableType
    public User userEntry(Map<String, String> entry) {
        return new User(entry.get(EMAIL.getConstant()), entry.get(PASSWORD.getConstant()));
    }

    @When("I login with credentials with data")
    public void iLoginWithCredentialsWithValidData(User user) {
        theActorInTheSpotlight().attemptsTo(LoginUser.withCredentials(user));
    }

    @Then("The service answers me status code {int}")
    public void stheServiceAnswersMeStatusCode(int statusCode) {
        theActorInTheSpotlight().should(seeThat(ValidateStatusCode.validate(), Matchers.equalTo(statusCode)));
    }

    @Then("I get a token")
    public void iGetAToken() {
        theActorInTheSpotlight().should(seeThat(ValidateToken.token(), Matchers.notNullValue()));
    }

}
