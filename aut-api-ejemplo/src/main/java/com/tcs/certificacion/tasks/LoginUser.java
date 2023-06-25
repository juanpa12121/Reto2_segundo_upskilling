package com.tcs.certificacion.tasks;

import com.tcs.certificacion.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class LoginUser implements Task{

    private User user;

    public LoginUser(User user) {
        this.user = user;
    }

    public static LoginUser withCredentials(User user) {
        return Tasks.instrumented(LoginUser.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/login")
                        .with(rq -> rq
                                .header("Content-Type", "application/json; charset=utf-8")
                                .relaxedHTTPSValidation()
                                .body(user)
        ));
        System.out.println("Response");
        SerenityRest.lastResponse().prettyPrint();
        //actor.remember("token", SerenityRest.lastResponse().jsonPath().get("token"));;
    }
}
