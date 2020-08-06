package com.telecom.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomerSteps {
	WebDriver driver;

	@Given("User launch the telecom site")
	public void user_launch_the_telecom_site() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
		driver.manage().window().maximize();
	}

	@Given("User click on add customer button")
	public void user_click_on_add_customer_button() throws InterruptedException {
		handleFrame();
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("User filling up all the details")
	public void user_filling_up_all_the_details() throws InterruptedException  {
		handleFrame();
		driver.findElement(By.xpath("//*[@id=\'main\']/div/form/div/div[1]/label")).click();
		driver.findElement(By.id("fname")).sendKeys("Praveen");
		driver.findElement(By.id("lname")).sendKeys("Kumar");
		driver.findElement(By.id("email")).sendKeys("pravinanand07@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("Chennai");
		driver.findElement(By.id("telephoneno")).sendKeys("6380579867");	   
	}

	@When("User click on submit button")
	public void user_click_on_submit_button() throws Exception {
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	}

	@Then("User will be displayed with the customer ID generated")
	public void user_will_be_displayed_with_the_customer_ID_generated() throws InterruptedException {
		handleFrame();
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
		String text = driver.findElement(By.xpath("//td[@align='center'])[2]")).getText();
		System.out.println(text);
	}
	
	public void handleFrame() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame("flow_close_btn_iframe");
		driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
		driver.switchTo().defaultContent();
	}


}
