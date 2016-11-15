package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class PF_HTMLUnit {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//if (args.length == 0) {
			//System.err.println("No arguments!");
		    //System.exit(1);
		    //}
		String text_case_id = null;
		String url = null;
		String title_expected = null;

		Properties properties = new Properties();

		properties.load(new FileInputStream("./src/main/resources/properties_1"));

		text_case_id = properties.getProperty("text_case_id");
		url = properties.getProperty("url");
		title_expected = properties.getProperty("title_expected");

		WebDriver driver = new HtmlUnitDriver();

		//for (int i = 0; i < args.length; i++){
			//String text_case_id = "TC-002.0" + (i + 1);
			
		//String text_case_id = "TC-002.01";
		//String browser = "HtmlUnit";
		//String url = "http://www.learn2test.net";
		//String title_expected = "learn2test.net";
		
        //String param[] = args[i].split("\\|");
		
		//String url = param[0];
		//String title_expected = param[1];
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
		
		
		driver.quit();
	}
}
