package testcase;

import org.testng.annotations.Test;

public class LearnAttributes {

	@Test(invocationCount = 5)
	public void createLead() {
		System.out.println("Create Lead");
	}
	
	@Test(invocationCount = 2, priority = -3)
	public void createLead1() {
		System.out.println("Create Lead 1");
	}

	@Test(priority = 1, alwaysRun = true)
	public void editLead() {
		System.out.println("Edit Lead");
	}

	@Test(enabled = false)
	public void deleteLead() {
		System.out.println("Delete Lead");
	}
}
