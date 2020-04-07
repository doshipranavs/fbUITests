package Com.fb.runner;

import com.fb.proj.util.Debugger;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
         plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json"},
         glue = {"Com.fb.steps"},
         features = {"src/test/resources/features"},
         tags = "(@general or @notimplemented) and (not @ignore or @manual)"
        )
    public class RunnerTest {
        @BeforeClass
        public static void setup() {
            Debugger.println("\n******* RUN STARTS " + new java.util.Date() + " *******************************");
        }

    }//end