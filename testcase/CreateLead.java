package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@BeforeClass
	public void setData() {
		fileName = "CreateLead";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void runCreateLead(String cName, String fName, String lName) {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
	}

	/*
	 * @DataProvider(name = "fetchData") public String[][] setData() throws
	 * IOException {
	 * 
	 * String[][] data = new String[2][3];
	 * 
	 * data[0][0] = "TestLeaf"; data[0][1] = "Baskar"; data[0][2] = "M";
	 * 
	 * data[1][0] = "Unisoft"; data[1][1] = "Nazim"; data[1][2] = "J";
	 * 
	 * 
	 * String[][] data = ReadExcel.readData();
	 * 
	 * return data; }
	 */
}
