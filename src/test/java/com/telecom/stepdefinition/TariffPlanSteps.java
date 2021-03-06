package com.telecom.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TariffPlanSteps {


	@Given("User Click on Add Tariff Plan button")
	public void user_Click_on_Add_Tariff_Plan_button() throws Exception {
		
		WebElement tar = Hook.driver.findElement(By.xpath("(//a[@href='addtariffplans.php'])[1]"));
		tar.click();
	}

	@When("User filling up all the details of the tariff plan")
	public void user_filling_up_all_the_details_of_the_tariff_plan() throws Exception {
		
		handleFrame();

		Hook.driver.findElement(By.id("rental1")).sendKeys("200");
		Hook.driver.findElement(By.id("local_minutes")).sendKeys("100");
		Hook.driver.findElement(By.id("inter_minutes")).sendKeys("150");
		Hook.driver.findElement(By.id("sms_pack")).sendKeys("100");
		Hook.driver.findElement(By.id("minutes_charges")).sendKeys("1");
		Hook.driver.findElement(By.id("inter_charges")).sendKeys("5");
		Hook.driver.findElement(By.id("sms_charges")).sendKeys("1");
	}
	
	@When("User filling up all the details of the tariff plan with one dim list")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_one_dim_list(DataTable tarif) throws Exception {
	    
		handleFrame();
		
		List<String> data = tarif.asList();
		
		Hook.driver.findElement(By.id("rental1")).sendKeys(data.get(0));
		Hook.driver.findElement(By.id("local_minutes")).sendKeys(data.get(1));
		Hook.driver.findElement(By.id("inter_minutes")).sendKeys(data.get(2));
		Hook.driver.findElement(By.id("sms_pack")).sendKeys(data.get(3));
		Hook.driver.findElement(By.id("minutes_charges")).sendKeys(data.get(4));
		Hook.driver.findElement(By.id("inter_charges")).sendKeys(data.get(5));
		Hook.driver.findElement(By.id("sms_charges")).sendKeys(data.get(6));
		
	}
	
	@When("User filling up all the details of the tariff plan with one dim map")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_one_dim_map(DataTable tarif1) throws Exception {
	    
		handleFrame();
		
		Map<String,String> data = tarif1.asMap(String.class, String.class);
		
		Hook.driver.findElement(By.id("rental1")).sendKeys(data.get("Rent"));
		Hook.driver.findElement(By.id("local_minutes")).sendKeys(data.get("Flm"));
		Hook.driver.findElement(By.id("inter_minutes")).sendKeys(data.get("Fim"));
		Hook.driver.findElement(By.id("sms_pack")).sendKeys(data.get("Fsp"));
		Hook.driver.findElement(By.id("minutes_charges")).sendKeys(data.get("Lpm"));
		Hook.driver.findElement(By.id("inter_charges")).sendKeys(data.get("Ipm"));
		Hook.driver.findElement(By.id("sms_charges")).sendKeys(data.get("Spc"));
		
	}
	
	@When("User filling up all the details of the tariff plan with two dim list")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_two_dim_list(DataTable tarif2) throws Exception {
	    
		handleFrame();
		
		List<List<String>> data1 = tarif2.asLists();
		
		Hook.driver.findElement(By.id("rental1")).sendKeys(data1.get(3).get(0));
		Hook.driver.findElement(By.id("local_minutes")).sendKeys(data1.get(1).get(1));
		Hook.driver.findElement(By.id("inter_minutes")).sendKeys(data1.get(4).get(2));
		Hook.driver.findElement(By.id("sms_pack")).sendKeys(data1.get(2).get(3));
		Hook.driver.findElement(By.id("minutes_charges")).sendKeys(data1.get(3).get(4));
		Hook.driver.findElement(By.id("inter_charges")).sendKeys(data1.get(0).get(5));
		Hook.driver.findElement(By.id("sms_charges")).sendKeys(data1.get(2).get(6));
		
	}
	
	@When("User filling up all the details of the tariff plan with two dim map")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_two_dim_map(DataTable tarif3) throws Exception {
	    
		handleFrame();
		
		List<Map<String, String>> data2 = tarif3.asMaps(String.class,String.class);
		
		Hook.driver.findElement(By.id("rental1")).sendKeys(data2.get(2).get("Rent"));
		Hook.driver.findElement(By.id("local_minutes")).sendKeys(data2.get(0).get("Flm"));
		Hook.driver.findElement(By.id("inter_minutes")).sendKeys(data2.get(2).get("Fim"));
		Hook.driver.findElement(By.id("sms_pack")).sendKeys(data2.get(4).get("Fsp"));
		Hook.driver.findElement(By.id("minutes_charges")).sendKeys(data2.get(3).get("Lpm"));
		Hook.driver.findElement(By.id("inter_charges")).sendKeys(data2.get(1).get("Ipm"));
		Hook.driver.findElement(By.id("sms_charges")).sendKeys(data2.get(2).get("Spc"));
		
	}
	
	@When("User clicks the submit button")
	public void user_clicks_the_submit_button() throws Exception {
		
		WebElement sub = Hook.driver.findElement(By.xpath("//input[@type='submit']"));
		sub.click();
	}

	@Then("User will be displayed with congratulation message")
	public void user_will_be_displayed_with_congratulation_message() throws Exception {
		
		handleFrame();
		
		String text = Hook.driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
	}

	public void handleFrame() throws InterruptedException {
		Thread.sleep(5000);
		Hook.driver.switchTo().frame("flow_close_btn_iframe");
		Hook.driver.findElement(By.id("closeBtn")).click();
		Hook.driver.switchTo().defaultContent();

	}
}
