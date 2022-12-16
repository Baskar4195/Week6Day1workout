package testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Week6Day2Workout.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ChromeDriver driver;
	public String fileName;
	
	@Parameters({"url","name","password"})
	@BeforeMethod     //(groups = {"common"})
	public void preCondition(@Optional("http://leaftaps.com/opentaps/")String url, @Optional("Democsr") String uName, String pwd) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
}
	@AfterMethod          //(groups = {"smoke","sanity","regression"})
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
				
   return ReadExcel.readData(fileName);
		
	}
}
