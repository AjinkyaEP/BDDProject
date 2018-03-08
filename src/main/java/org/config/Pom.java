/***********************************************************************************************************
 OBJECTIVE:- This is a utility class which provides utility methods which is required to support automation
 AUTHOR:- Ajinkya Chudiwal	
 EMAIL:-ajinkya_chudiwal@epam.com
 DATE:- 05/03/2018
 ***********************************************************************************************************/
package org.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pom 
{
	private static String url="http://www.cleartrip.com/";
	private static String chromeDriverPath="./src/main/resources/chromedriver.exe";
	private static String logFilePath="./log4j.properties";
	private static String testDataFileName="./src/main/resources/data.json";
	private static String testDataExcelFileName="./src/main/resources/data.xlsx";
	private static Logger logger;
	public WebDriver driver=null;
	
	//This method assists in initializing Web driver. 
	public void intializeDriver()
	{
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(url);
	}
	
	//This method assists in quitting the driver. 
	public void quitDriver()
	{
		driver.quit();
	}
	
	//This method assists in initializing log utility.
	public static Logger log() 
	{
		String log4jConfigFile = logFilePath;
	    PropertyConfigurator.configure(log4jConfigFile);
	    return logger;
	}
	
	//Read Data from JSON file
	public String readData(String scenarioName, String parameter)
	{
		File file = new File(testDataFileName);
	    String content = null;
		try 
		{
			content = FileUtils.readFileToString(file, "utf-8");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject(content);	
		JSONObject scenarioObject = obj.getJSONObject(scenarioName);
		String value = scenarioObject.getString(parameter);
		return value;
	}
	
	//Read Data from Excel file
	public String readExcel(String scenarioName, String parameter)
	{
		InputStream ExcelFileToRead = null;
		XSSFWorkbook workbook = null;
	
		XSSFRow row; 
		XSSFCell cell;
		String parameterValue = null;
		
		try 
		{
			ExcelFileToRead = new FileInputStream(testDataExcelFileName);
			workbook = new XSSFWorkbook(ExcelFileToRead);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//Iterate each row
		Iterator rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			if(row.getCell(0).getStringCellValue().equals(scenarioName))
			{
				switch(parameter)
				{
					case "Flight from":			parameterValue=row.getCell(1).getStringCellValue();
												break;
										
					case "Destination place":	parameterValue=row.getCell(2).getStringCellValue();
												break;
					
					case "Departure date":		parameterValue=row.getCell(3).getStringCellValue();
												break;
					
					case "Return date":			parameterValue=row.getCell(4).getStringCellValue();
												break;
					
					default:					logger.error("Unable to find required parameter");
												break;
				}
				break;
			}
		}
		return parameterValue;
	}
}
