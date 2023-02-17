package com.tests.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.utils.fixturesfactory.Job;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Post {
    @BeforeSuite
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("com.utils.templatesfix");
    }



    @DataProvider(parallel = true)
    public static Object[][] getData() {
       Job valid= Fixture.from(Job.class).gimme("valid");

        return new Object[][]{
                {
                   valid
                }

        };
    }






    @Test(dataProvider = "getData")
    public void postjob(Job job) {

        Response response = given().contentType(ContentType.JSON)
                .log()
                .all()
                .body(job) //jackson
                .post("https://reqres.in/api/users");

        Assert.assertEquals(response.getStatusCode(),201);

    }
}
