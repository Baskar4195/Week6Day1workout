package testcase;

import org.testng.annotations.Test;

public class Dependency {
	@Test()
	public void createLead() {
		System.out.println("Create Lead");
		throw new RuntimeException();
	}

	@Test()
	public void deleteLead() {
		System.out.println("Delete Lead");
	}

	@Test(dependsOnMethods = { "testcase.Dependency.createLead","deleteLead" }, alwaysRun = true)
	public void editLead() {
		System.out.println("Edit Lead");
	}
}
