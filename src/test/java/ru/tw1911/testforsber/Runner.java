package ru.tw1911.testforsber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features"
        ,glue={"ru.tw1911.testforsber.application"}
        ,plugin = {"pretty"}
        , tags = {"@Cart"}
        ,snippets = SnippetType.CAMELCASE
)
public class Runner {

    @Test
    public void cartTest() {

    }
}
