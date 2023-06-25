package com.tcs.certificacion.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateToken implements Question<String>{

    public static ValidateToken token(){
        return new ValidateToken();
    }

    @Override
    public String answeredBy(Actor actor) {
        String token = SerenityRest.lastResponse().jsonPath().get("token");
        return token == null ? "" : token ;
    }
}
