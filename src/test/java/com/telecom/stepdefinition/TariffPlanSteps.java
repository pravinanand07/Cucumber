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

	WebDriver driver;

	@Given("User launch the Tariff plan site")
	public void user_launch_the_Tariff_plan_site() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
	}

	@Given("User Click on Add Tariff Plan button")
	public void user_Click_on_Add_Tariff_Plan_button() throws Exception {
		
		handleFrame();
		
		WebElement tar = driver.findElement(By.xpath("(//a[@href='addtariffplans.php'])[1]"));
		tar.click();
	}

	@When("User filling up all the details of the tariff plan")
	public void user_filling_up_all_the_details_of_the_tariff_plan() throws Exception {
		
		handleFrame();

		driver.findElement(By.id("rental1")).sendKeys("200");
		driver.findElement(By.id("local_minutes")).sendKeys("100");
		driver.findElement(By.id("inter_minutes")).sendKeys("150");
		driver.findElement(By.id("sms_pack")).sendKeys("100");
		driver.findElement(By.id("minutes_charges")).sendKeys("1");
		driver.findElement(By.id("inter_charges")).sendKeys("5");
		driver.findElement(By.id("sms_charges")).sendKeys("1");
	}
	
	@When("User filling up all the details of the tariff plan with one dim list")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_one_dim_list(DataTable tarif) throws Exception {
	    
		handleFrame();
		
		List<String> data = tarif.asList();
		
		driver.findElement(By.id("rental1")).sendKeys(data.get(0));
		driver.findElement(By.id("local_minutes")).sendKeys(data.get(1));
		driver.findElement(By.id("inter_minutes")).sendKeys(data.get(2));
		driver.findElement(By.id("sms_pack")).sendKeys(data.get(3));
		driver.findElement(By.id("minutes_charges")).sendKeys(data.get(4));
		driver.findElement(By.id("inter_charges")).sendKeys(data.get(5));
		driver.findElement(By.id("sms_charges")).sendKeys(data.get(6));
		
	}
	
	@When("User filling up all the details of the tariff plan with one dim map")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_one_dim_map(DataTable tarif1) throws Exception {
	    
		handleFrame();
		
		Map<String,String> data = tarif1.asMap(String.class, String.class);
		
		driver.findElement(By.id("rental1")).sendKeys(data.get("Rent"));
		driver.findElement(By.id("local_minutes")).sendKeys(data.get("Flm"));
		driver.findElement(By.id("inter_minutes")).sendKeys(data.get("Fim"));
		driver.findElement(By.id("sms_pack")).sendKeys(data.get("Fsp"));
		driver.findElement(By.id("minutes_charges")).sendKeys(data.get("Lpm"));
		driver.findElement(By.id("inter_charges")).sendKeys(data.get("Ipm"));
		driver.findElement(By.id("sms_charges")).sendKeys(data.get("Spc"));
		
	}
	
	@When("User filling up all the details of the tariff plan with two dim list")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_two_dim_list(DataTable tarif2) throws Exception {
	    
		handleFrame();
		
		List<List<String>> data1 = tarif2.asLists();
		
		driver.findElement(By.id("rental1")).sendKeys(data1.get(3).get(0));
		driver.findElement(By.id("local_minutes")).sendKeys(data1.get(1).get(1));
		driver.findElement(By.id("inter_minutes")).sendKeys(data1.get(4).get(2));
		driver.findElement(By.id("sms_pack")).sendKeys(data1.get(2).get(3));
		driver.findElement(By.id("minutes_charges")).sendKeys(data1.get(3).get(4));
		driver.findElement(By.id("inter_charges")).sendKeys(data1.get(0).get(5));
		driver.findElement(By.id("sms_charges")).sendKeys(data1.get(2).get(6));
		
	}
	
	@When("User filling up all the details of the tariff plan with two dim map")
	public void user_filling_up_all_the_details_of_the_tariff_plan_with_two_dim_map(DataTable tarif3) throws Exception {
	    
		handleFrame();
		
		List<Map<String, String>> data2 = tarif3.asMaps(String.class,String.class);
		
		driver.findElement(By.id("rental1")).sendKeys(data2.get(2).get("Rent"));
		driver.findElement(By.id("local_minutes")).sendKeys(data2.get(0).get("Flm"));
		driver.findElement(By.id("inter_minutes")).sendKeys(data2.get(2).get("Fim"));
		driver.findElement(By.id("sms_pack")).sendKeys(data2.get(4).get("Fsp"));
		driver.findElement(By.id("minutes_charges")).sendKeys(data2.get(3).get("Lpm"));
		driver.findElement(By.id("inter_charges")).sendKeys(data2.get(1).get("Ipm"));
		driver.findElement(By.id("sms_charges")).sendKeys(data2.get(2).get("Spc"));
		
	}
	
	@When("User clicks the submit button")
	public void user_clicks_the_submit_button() throws Exception {
		
		WebElement sub = driver.findElement(By.xpath("//input[@type='submit']"));
		sub.click();
	}

	@Then("User will be displayed with congratulation message")
	public void user_will_be_displayed_with_congratulation_message() throws Exception {
		
		handleFrame();
		
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
	}

	public void handleFrame() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame("flow_close_btn_iframe");
		driver.findElement(By.id("closeBtn")).click();
		driver.switchTo().defaultContent();

	}
}
