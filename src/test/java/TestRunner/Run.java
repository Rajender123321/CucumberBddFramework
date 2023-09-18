package TestRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions
(
		features = ".//Features/LoginFeature.feature",
		//features = {".//Features/Customers.feature",".//Features/LoginFeature.feature"},
		//features = ".//Features/",
		//features = "@target/rerun.txt",
		
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		//tags = "@DataDriven",
		tags = "@sanity",
		//tags = "@regression",
		//tags = "@sanity or @regression",
		//tags = "@sanity and @regression",
		//tags = "@sanity and not @regression",
		//plugin = {"pretty","html:target/Cucumber_reports/reports1.html","json:target/Cucumber_reports/reports_json.json",
				 //  "junit:target/Cucumber_reports/report_xml.xml","rerun:target/rerun.txt"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

//plugin = {"pretty","json:target/Cucumber_reports/reports_json.json"}
//plugin = {"pretty","junit:target/Cucumber_reports/report_xml.xml"}
public class Run extends AbstractTestNGCucumberTests{

}
