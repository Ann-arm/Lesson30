package API_homework20;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework20 {

    private final static String URL = "https://reqres.in/";

    @Test
    public void compareText() {
        SpecificationHomework.installSpecification(SpecificationHomework.requestSpecification(URL),
                SpecificationHomework.responseSpecification(200));

        ResourceData resourceData = given()
                .when()
                .get("api/unknown/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("support", ResourceData.class);

        Assert.assertTrue(resourceData.getText().equals("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}
