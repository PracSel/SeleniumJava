import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaSeleniumAutomation {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//textbox
		driver.findElement(By.id("name")).sendKeys("User 1");
		driver.findElement(By.id("email")).sendKeys("username@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("+65 0000 0000");
		driver.findElement(By.id("textarea")).sendKeys("Address Line 1 Line 2 ");
		
		//radion button
		//driver.findElement(By.id("male")).click();
		driver.findElement(By.id("female")).click();
		
		//checkbox
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@class='form-check-input'and@type='checkbox']"));
		int count=checkbox.size();
		System.out.println("Total count :"+count);
		
		for(int i=0;i<checkbox.size();i++)
		{
			checkbox.get(i).click();
			
		}
		
		
		
		
		//static table
		
		int row=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of rows :"+row);
		
		int col=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of Column:" +col);
		
		for(int r=2;r<=row;r++)
		{
			for(int c=1;c<=col;c++)
			{
				String tablevalue=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(tablevalue+"\t");
				
			}
			System.out.println();
		}
		
		//Alert
		
		
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[1]")).click();//normal allert
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[2]")).click();//confirm alert
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		String text=driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[3]")).click();//prompt alert
		Alert myalert=driver.switchTo().alert();
		myalert.sendKeys("Welcome");
		driver.switchTo().alert().accept();
		String text1=driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
		System.out.println(text1);
		
		//double click
		WebElement textbox1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement textbox2=driver.findElement(By.xpath("//input[@id='field2']"));
		
		WebElement button=driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
		
		textbox1.clear();
		textbox1.sendKeys("Automation");
		
		Actions act=new Actions(driver);
		act.doubleClick(button).build().perform();
		
		
		//driver.quit();

	}

}
