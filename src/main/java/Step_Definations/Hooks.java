package Step_Definations;

import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }

    @Before("@web")
    public void setupScenarioForLogins(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");

        WebDriver webDriver=new ChromeDriver(options);
    }

    //@Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }


    @After
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value


        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        BrowserUtils.sleep(5);
        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

    // @BeforeStep
    public void setupStep(){
        System.out.println("--------> applying setup using @BeforeStep");
    }

    //  @AfterStep
    public void afterStep(){
        System.out.println("--------> applying tearDown using @AfterStep");
    }


}
