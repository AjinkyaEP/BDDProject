package org.utility;

import org.apache.log4j.Logger;
import org.config.Pom;
import org.stepDefinition.StepDefinition;
import org.testng.IExecutionListener;
import org.utility.GenerateReport;


public class TestNGExecutionListener implements IExecutionListener 
{
	private static Logger log=Pom.logger.getLogger(TestNGExecutionListener.class);
    public void onExecutionStart() 
    {
        log.info("TestNG is starting the execution");
    }
    
    public void onExecutionFinish() 
    {
        log.info("Generating the Masterthought Report");
        GenerateReport.GenerateMasterthoughtReport();
        log.info("TestNG has finished, the execution");
    }
}
