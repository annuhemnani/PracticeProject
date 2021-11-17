package academy.practiceproject;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.MainclassObject;

public class MainPage extends Base {
	
	@BeforeTest
	
	public void beforeTest() throws IOException {
		WebDriver driver=intializeDriver();
		driver.get("https://courses.letskodeit.com/practice");


	}
	
	@Test
	public void pageTitleVerifyTest() {
		String pageTitle= driver.getTitle();
		Assert.assertEquals(pageTitle, "Practice Page");
	}
	
	@Test
	public void verifyUrl() {
		String url= driver.getCurrentUrl();
		Assert.assertEquals(url, "https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void byDefaultSelectedRadioButton() {
	MainclassObject o= new MainclassObject(driver);
Assert.assertFalse(	o.getbmwradiobutton().isSelected());
Assert.assertFalse(	o.getbenzradiobutton().isSelected());
Assert.assertFalse(	o.gethondaradiobutton().isSelected());


	}
	@Test
	public void countRadioButtonNumber() {
		MainclassObject o= new MainclassObject(driver);
o.gethondaradiobutton().getSize();
Assert.assertEquals(o.getRadioButtonTotalCount().size(), 3);

	}
	
	@Test
	public void verifyRadioButtonLabels() {
		MainclassObject o= new MainclassObject(driver);

		Assert.assertEquals(o.getbenzradioButtonLabel().getText(), "Benz");
		Assert.assertEquals(o.getbmwradioButtonLabel().getText(), "BMW");
		Assert.assertEquals(o.gethondaradioButtonLabel().getText(), "Honda");


	}
	
	@Test
	public void selectBMWRadionButton() {
		MainclassObject o= new MainclassObject(driver);
		o.getbmwradiobutton().click();
		Assert.assertTrue(	o.getbmwradiobutton().isSelected());
		Assert.assertFalse(	o.getbenzradiobutton().isSelected());
		Assert.assertFalse(	o.gethondaradiobutton().isSelected());
}
	
	@Test
	public void selectBenzRadionButton() {
		MainclassObject o= new MainclassObject(driver);
		o.getbenzradiobutton().click();
		Assert.assertFalse(	o.getbmwradiobutton().isSelected());
		Assert.assertTrue(	o.getbenzradiobutton().isSelected());
		Assert.assertFalse(	o.gethondaradiobutton().isSelected());
	}
	@Test
	public void selectHondaRadionButton() {
		MainclassObject o= new MainclassObject(driver);
		o.gethondaradiobutton().click();
		Assert.assertFalse(	o.getbmwradiobutton().isSelected());
		Assert.assertFalse(	o.getbenzradiobutton().isSelected());
		Assert.assertTrue(	o.gethondaradiobutton().isSelected());
	}
	
	@Test
	public void dropdownText() {
		MainclassObject o= new MainclassObject(driver);
		Assert.assertEquals(o.dropdownOption().getFirstSelectedOption().getText(), "BMW");
		
	}
	
	@Test
	public void dropDownOptions() {
		MainclassObject o= new MainclassObject(driver);
		
		Assert.assertEquals(o.dropdownOption().getOptions().size(), 3);
		
	}
	@Test
	public void selectBenz() {
		MainclassObject o= new MainclassObject(driver);
		o.dropdownOption().selectByValue("benz");
	}
	
	@Test
	public void selectBmw() {
		MainclassObject o= new MainclassObject(driver);
		o.dropdownOption().selectByValue("bmw");
	}
	@Test
	public void selecthonda() {
		MainclassObject o= new MainclassObject(driver);
		o.dropdownOption().selectByValue("honda");
	}
	@Test
	public void  checkMultiSelectOption() {
		MainclassObject o= new MainclassObject(driver);
Assert.assertEquals(o.getmultipleSelectDropdown().getOptions().size(), 3);		
	}
	@Test
	public void selectEachOption()	{
		MainclassObject o= new MainclassObject(driver);
		o.getmultipleSelectDropdown().selectByValue("apple");
	System.out.println(	o.getmultipleSelectDropdown().getFirstSelectedOption().getText());
		Assert.assertTrue(o.getmultipleSelectDropdown().getFirstSelectedOption().isSelected());
		o.getmultipleSelectDropdown().selectByValue("orange");
		System.out.println(	o.getmultipleSelectDropdown().getFirstSelectedOption().getText());
			Assert.assertTrue(o.getmultipleSelectDropdown().getFirstSelectedOption().isSelected());
			o.getmultipleSelectDropdown().selectByValue("peach");
			System.out.println(	o.getmultipleSelectDropdown().getFirstSelectedOption().getText());
				Assert.assertTrue(o.getmultipleSelectDropdown().getFirstSelectedOption().isSelected());
	}
	@Test
	public void selectAllOption() {
		MainclassObject o= new MainclassObject(driver);
		o.getmultipleSelectDropdown().selectByValue("apple");
		o.getmultipleSelectDropdown().selectByValue("peach");
		o.getmultipleSelectDropdown().selectByValue("orange");
		int selectedOption=o.getmultipleSelectDropdown().getAllSelectedOptions().size();
		Assert.assertEquals(selectedOption, 3);
		o.getmultipleSelectDropdown().deselectAll();
		Assert.assertEquals(o.getmultipleSelectDropdown().getAllSelectedOptions().size(), 0);

	}
	@Test
	public void getcheckboxCount()	{
		MainclassObject o= new MainclassObject(driver);
Assert.assertEquals(o.getcheckboxcount(), 3);
	}
	@Test
	public void checkallCheckbox() {
		MainclassObject o= new MainclassObject(driver);
		o.getBenzCheckbox().click();
		o.getBMWCheckbox().click();
		o.getHondaCheckbox().click();
		Assert.assertTrue(o.getBenzCheckbox().isSelected());
		Assert.assertTrue(o.getBMWCheckbox().isSelected());
		Assert.assertTrue(o.getHondaCheckbox().isSelected());


		
	}
	
	@Test
	public void uncheckAllCheckbox() {
		MainclassObject o= new MainclassObject(driver);

		o.getBenzCheckbox().click();
		o.getBMWCheckbox().click();
		o.getHondaCheckbox().click();
		Assert.assertFalse(o.getBenzCheckbox().isSelected());
		Assert.assertFalse(o.getBMWCheckbox().isSelected());
		Assert.assertFalse(o.getHondaCheckbox().isSelected());
	}
	
	/*public void swithWindowExample() throws InterruptedException {
		MainclassObject o= new MainclassObject(driver);
		o.getOpenWindow().click();
	Set<String> windows=	driver.getWindowHandles();
	Iterator<String> iterator=windows.iterator();
	String parentWindow=iterator.next();
	String childWindow=iterator.next();
	driver.switchTo().window(childWindow);
	Thread.sleep(3000);
	System.out.println(driver.getCurrentUrl());
	Assert.assertEquals(driver.getCurrentUrl(), "https://courses.letskodeit.com/courses\r\n"
			+ "");
	driver.switchTo().window(parentWindow);
		}
	*/
	//not closing opened window
	/*public void closeOpenedWindow() {
		MainclassObject o= new MainclassObject(driver);
		o.getOpenWindow().click();
	Set<String> windows=	driver.getWindowHandles();
	Iterator<String> iterator=windows.iterator();
	String parentWindow=iterator.next();
	String childWindow=iterator.next();
	driver.switchTo().window(childWindow);
	driver.close();
	Assert.assertEquals(driver.getCurrentUrl(), "https://courses.letskodeit.com/practice");
	
	} */
	/*@Test
	public void swithTabExample() {
		MainclassObject o= new MainclassObject(driver);
		o.getopentab().click();
	Set<String> windows=	driver.getWindowHandles();
	Iterator<String> iterator=windows.iterator();
	String parentWindow=iterator.next();
	String childWindow=iterator.next();
	driver.switchTo().window(childWindow);
	System.out.println(driver.getCurrentUrl());
	Assert.assertEquals(driver.getCurrentUrl(), "https://courses.letskodeit.com/courses"
			+ "");
	
	Assert.assertEquals(driver.getTitle(), "All courses");
	driver.switchTo().window(parentWindow);
		}
	*/

	
	@Test
	public void zcloseOpenedTab() {
		MainclassObject o= new MainclassObject(driver);
		o.getopentab().click();
	Set<String> windows=	driver.getWindowHandles();
	Iterator<String> iterator=windows.iterator();
	String parentWindow=iterator.next();
	String childWindow=iterator.next();
	driver.switchTo().window(childWindow);
	driver.switchTo().window(parentWindow);
	Assert.assertEquals(driver.getCurrentUrl(), "https://courses.letskodeit.com/practice");
	
	}
	@Test
	public void switchToAlert() {
		MainclassObject o= new MainclassObject(driver);
		o.enterName().sendKeys("annu");
		o.getalertButton().click();
		driver.switchTo().alert().accept();
	}
	public void mouseHover() {
		MainclassObject o= new MainclassObject(driver);
		Actions a= new Actions(driver);
		a.moveToElement(o.mouseHover()).build().perform();
		
		
	}
	public void switchToFrame() {
		MainclassObject o= new MainclassObject(driver);
		driver.switchTo().frame("iframe-name");
		driver.findElement(By.cssSelector("a[href='/login']")).click();
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
