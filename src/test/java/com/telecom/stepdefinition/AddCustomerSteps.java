package com.telecom.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps {
	static WebDriver driver;

	@Given("User launch the telecom site")
	public void user_launch_the_telecom_site() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
	}

	@Given("User click on add customer button")
	public void user_click_on_add_customer_button() throws InterruptedException {
		handleFrame();
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("User filling up all the details")
	public void user_filling_up_all_the_details() throws InterruptedException {
		handleFrame();
		driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		driver.findElement(By.id("fname")).sendKeys("Praveen");
		driver.findElement(By.id("lname")).sendKeys("Kumar");
		driver.findElement(By.id("email")).sendKeys("pravinanand07@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("Chennai");
		driver.findElement(By.id("telephoneno")).sendKeys("6380579867");
	}

	@When("User filling up all the details with one dim list")
	public void user_filling_up_all_the_details_with_one_dim_list(DataTable cust) throws Exception {

		List<String> data = cust.asList();

		handleFrame();
		driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get(0));
		driver.findElement(By.id("lname")).sendKeys(data.get(1));
		driver.findElement(By.id("email")).sendKeys(data.get(2));
		driver.findElement(By.name("addr")).sendKeys(data.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));

	}
	
	@When("User filling up all the details with one dim map")
	public void user_filling_up_all_the_details_with_one_dim_map(DataTable cust) throws Exception {
	    
		Map<String, String> datas = cust.asMap(String.class, String.class);
		
		handleFrame();
		
		driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		driver.findElement(By.id("fname")).sendKeys(datas.get("Fn"));
		driver.findElement(By.id("lname")).sendKeys(datas.get("Ln"));
		driver.findElement(By.id("email")).sendKeys(datas.get("Ml"));
		driver.findElement(By.name("addr")).sendKeys(datas.get("Add"));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get("Ph"));
	}
	
	@When("User filling up all the details with two dim list")
	public void user_filling_up_all_the_details_with_two_dim_list(DataTable cust) throws Exception {

		List<List<String>> data = cust.asLists();

		handleFrame();
		driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get(2).get(0));
		driver.findElement(By.id("lname")).sendKeys(data.get(2).get(1));
		driver.findElement(By.id("email")).sendKeys(data.get(3).get(2));
		driver.findElement(By.name("addr")).sendKeys(data.get(3).get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get(0).get(4));

	}
	
	@When("User filling up all the details with two dim map")
	public void user_filling_up_all_the_details_with_two_dim_map(DataTable cust) throws Exception {
	    
		List<Map<String,String>> datas = cust.asMaps(String.class, String.class);
		
		handleFrame();
		
		driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		driver.findElement(By.id("fname")).sendKeys(datas.get(3).get("Fn"));
		driver.findElement(By.id("lname")).sendKeys(datas.get(2).get("Ln"));
		driver.findElement(By.id("email")).sendKeys(datas.get(2).get("Mail"));
		driver.findElement(By.name("addr")).sendKeys(datas.get(1).get("Addr"));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get(2).get("Phn"));
	}

	@When("User click on submit button")
	public void user_click_on_submit_button() throws Exception {
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	}

	@Then("User will be displayed with the customer ID generated")
	public void user_will_be_displayed_with_the_customer_ID_generated() throws InterruptedException {
		handleFrame();
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
		String text = driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
		System.out.println(text);
	}

	public void handleFrame() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame("flow_close_btn_iframe");
		driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
		driver.switchTo().defaultContent();
	}

}
