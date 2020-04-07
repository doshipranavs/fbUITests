package com.fb.aXe;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import java.net.URL;

import static org.junit.Assert.assertTrue;

public class Accessibility {
	@Rule
	public TestName testName = new TestName();
	WebDriver driver;
	public Accessibility(WebDriver driver){
		this.driver=driver;
	}
	private static final URL scriptUrl = Accessibility.class.getResource("/axe.min.js");


	/**
	 * Basic test
	 */

	public void testAccessibility() {
		JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

		JSONArray violations = responseJSON.getJSONArray("violations");

		if (violations.length() == 0) {
			assertTrue("No violations found", true);
		} else {
			AXE.writeResults(testName.getMethodName(), responseJSON);
			assertTrue(AXE.report(violations), false);
		}
	}
}