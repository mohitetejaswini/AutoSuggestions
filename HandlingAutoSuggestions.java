package com.pack2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAutoSuggestions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TEJU\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(5000);
		List <WebElement> allSuggestions = driver.findElements(By.xpath("//span[contains(text(), 'selenium')"));
		int count = allSuggestions.size();
		System.out.println(count);
		
		for(WebElement suggestion : allSuggestions)
		{
			String text = suggestion.getText();
			System.out.println(text);
		}
		
		String expectedSuggestionToBeSelected = "selenium grid";
		
		for(WebElement sugg : allSuggestions)
		{
			if(sugg.equals(expectedSuggestionToBeSelected))
			{
				sugg.click();
				break;
			}
		}
	}

}
