package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

features = "src/test/resources/Features/fabiLocadora.feature",
glue = "Steps",
tags = {},
plugin = {"pretty", "html: target/report-html", "json:target/report.json"},
monochrome = false,
//esse plugin irá juntar o nome do metodo sem usar underline
snippets = SnippetType.CAMELCASE,
dryRun = false,
strict = false

)

public class RunnerTest {
				

}



