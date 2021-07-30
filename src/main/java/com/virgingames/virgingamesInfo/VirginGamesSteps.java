package com.virgingames.virgingamesInfo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.virgingames.constants.EndPoints;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.List;

public class VirginGamesSteps {

    @Step("Getting all bingo lobby information")
    public ValidatableResponse getBingoLobbyInfo(){

        return SerenityRest.rest()
                .given().log().all()
                .contentType(ContentType.TEXT)
                .when()
                .get(EndPoints.GET_ALL_VIRGINGAMES)
                .then();
    }

}
