/***************************************************************************************************************************
 OBJECTIVE:- This is a TestNG and Cucumber integration class which acts runner to run tests mentioned in Cucumber Option.
 AUTHOR:- Ajinkya Chudiwal	
 EMAIL:-ajinkya_chudiwal@epam.com
 DATE:- 05/03/2018
 ****************************************************************************************************************************/
package org.stepDefinition;
import cucumber.api.*;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/test/resources/ClearTripApplication.feature",
        tags = "@SearchFlightOneWay",
        plugin = "json:target/cucumber1.json")
public class TestRunner1 {
    private TestNGCucumberRunner testNGCucumberRunner;	

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass()); 	//Bootstraps the Cucumber runtime
    }

    //This helps to run scenarios retrieved from Data provider
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) { 	
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());	//Runs the cucumber feature
    }
    
    //This Data provider provides list of cucumber scenarios which needs to be run.
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
