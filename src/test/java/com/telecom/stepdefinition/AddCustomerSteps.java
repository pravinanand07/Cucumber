package com.telecom.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps {
	

	@Given("User click on add customer button")
	public void user_click_on_add_customer_button() throws InterruptedException {
		handleFrame();
		Hook.driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("User filling up all the details")
	public void user_filling_up_all_the_details() throws InterruptedException {
		handleFrame();
		Hook.driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys("Praveen");
		Hook.driver.findElement(By.id("lname")).sendKeys("Kumar");
		Hook.driver.findElement(By.id("email")).sendKeys("pravinanand07@gmail.com");
		Hook.driver.findElement(By.name("addr")).sendKeys("Chennai");
		Hook.driver.findElement(By.id("telephoneno")).sendKeys("6380579867");
	}

	@When("User filling up all the details with one dim list")
	public void user_filling_up_all_the_details_with_one_dim_list(DataTable cust) throws Exception {

		List<String> data = cust.asList();

		handleFrame();
		Hook.driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(data.get(0));
		Hook.driver.findElement(By.id("lname")).sendKeys(data.get(1));
		Hook.driver.findElement(By.id("email")).sendKeys(data.get(2));
		Hook.driver.findElement(By.name("addr")).sendKeys(data.get(3));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));

	}
	
	@When("User filling up all the details with one dim map")
	public void user_filling_up_all_the_details_with_one_dim_map(DataTable cust) throws Exception {
	    
		Map<String, String> datas = cust.asMap(String.class, String.class);
		
		handleFrame();
		
		Hook.driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(datas.get("Fn"));
		Hook.driver.findElement(By.id("lname")).sendKeys(datas.get("Ln"));
		Hook.driver.findElement(By.id("email")).sendKeys(datas.get("Ml"));
		Hook.driver.findElement(By.name("addr")).sendKeys(datas.get("Add"));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(datas.get("Ph"));
	}
	
	@When("User filling up all the details with two dim list")
	public void user_filling_up_all_the_details_with_two_dim_list(DataTable cust) throws Exception {

		List<List<String>> data = cust.asLists();

		handleFrame();
		Hook.driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(data.get(2).get(0));
		Hook.driver.findElement(By.id("lname")).sendKeys(data.get(2).get(1));
		Hook.driver.findElement(By.id("email")).sendKeys(data.get(3).get(2));
		Hook.driver.findElement(By.name("addr")).sendKeys(data.get(3).get(3));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(data.get(0).get(4));

	}
	
	@When("User filling up all the details with two dim map")
	public void user_filling_up_all_the_details_with_two_dim_map(DataTable cust) throws Exception {
	    
		List<Map<String,String>> datas = cust.asMaps(String.class, String.class);
		
		handleFrame();
		
		Hook.driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(datas.get(3).get("Fn"));
		Hook.driver.findElement(By.id("lname")).sendKeys(datas.get(2).get("Ln"));
		Hook.driver.findElement(By.id("email")).sendKeys(datas.get(2).get("Mail"));
		Hook.driver.findElement(By.name("addr")).sendKeys(datas.get(1).get("Addr"));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(datas.get(2).get("Phn"));
	}

	@When("User click on submit button")
	public void user_click_on_submit_button() throws Exception {
		Hook.driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	}

	@Then("User will be displayed with the customer ID generated")
	public void user_will_be_displayed_with_the_customer_ID_generated() throws InterruptedException {
		handleFrame();
		Assert.assertTrue(Hook.driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
		String text = Hook.driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
		System.out.println(text);
	}

	public void handleFrame() throws InterruptedException {
		Thread.sleep(5000);
		Hook.driver.switchTo().frame("flow_close_btn_iframe");
		Hook.driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
		Hook.driver.switchTo().defaultContent();
	}

}
